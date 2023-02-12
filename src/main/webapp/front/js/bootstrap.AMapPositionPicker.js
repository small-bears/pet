/**
 * BootstrapAMapPositionPicker v0.8.3
 * @author: Kinegratii
 */
(function (factory) {
    'use strict';
    if (typeof define === 'function' && define.amd) {
        define(['jquery', 'AMap'], factory);
    } else if (typeof exports === 'object') {
        module.exports = factory(require('jquery'), require('AMap'));
    } else {
        if (typeof jQuery === 'undefined') {
            throw 'AMapPositionPicker requires jQuery to be loaded first';
        }
        if (typeof  AMap == 'undefined') {
            throw 'AMapPositionPicker requires AMap to be loaded first';
        }
        factory(jQuery, AMap);
    }
}(function ($, AMap) {
    // Global tool functions
    String.prototype.format = function (data) {
        var result = this;
        for (var key in data) {
            if (data[key] != undefined) {
                var reg = new RegExp("({" + key + "})", "g");
                result = result.replace(reg, data[key]);
            }
        }
        return result;
    };
    if (typeof String.prototype.startsWith != 'function') {
        String.prototype.startsWith = function (prefix) {
            return this.slice(0, prefix.length) === prefix;
        };
    }

    function wrapFormat(formatter, data) {
        if (typeof formatter == 'function') {
            return formatter(data);
        } else if (typeof formatter == 'string') {
            return formatter.format(data);
        } else {
            return '';
        }
    }

    // Data Structure Start
    var Position = (function () {
        function Position(longitude, latitude, address, label) {
            this.longitude = longitude;
            this.latitude = latitude;
            this.address = address || '';
            this.label = label || '';
        }

        Position.prototype.isValid = function () {
            return this.longitude != undefined && this.longitude != null && this.latitude != undefined && this.latitude != null;
        };
        Position.prototype.copy = function (data) {
            if (data == undefined) {
                return new Position(this.longitude, this.latitude, this.address, this.label);
            } else {
                return new Position(
                    data.longitude || this.longitude,
                    data.latitude || this.latitude,
                    data.address || this.address,
                    data.label || this.label
                );
            }
        };
        Position.prototype.getDisplayString = function () {
            if (this.label) {
                return this.label;
            } else {
                return this.address;
            }
        };
        Position.fromOptions = function (options) {
            if (options instanceof Position) {
                return options;
            } else {
                return new Position(options.longitude, options.latitude, options.address, options.label);
            }
        };
        Position.empty = function () {
            return new Position(null, null, "", "");
        };
        Position.validate = function (position) {
            if (position) {
                return position.isValid();
            } else {
                return false;
            }
        };
        Position.validateLngLat = function (lnglatStr) {
            var result = /^([+-]?(0?\d{1,2}(\.\d{1,6})?|1[0-7]?\d{1}(\.\d{1,6})?|180\.0{1,6}))[-;,]([-+]?([0-8]?\d{1}(\.\d{1,6})?|90(\.0{1,6})?))$/.exec(lnglatStr);
            if (result) {
                return {longitude: parseFloat(result[1]), latitude: parseFloat(result[5])};
            } else {
                return null;
            }
        };
        Position.LNGLAT_FORMATTER = ['{longitude}-{latitude}', '{longitude};{latitude}', '{longitude},{latitude}'];
        return Position;
    }());

    var Field = (function () {
        var idIndex = -1;

        function generateSelectorId(selector) {
            if (selector.startsWith('#')) {
                return selector.substring(1);
            } else {
                idIndex += 1;
                return 'id_ampp_i' + idIndex;
            }
        }

        function Field(options) {
            this.name = options.name;
            if (options.selector instanceof jQuery) {
                this.$widget = options.selector;
                this.created = true;
            }
            else if ($(options.selector).length > 0) {
                this.$widget = $(options.selector);
                this.created = true;
            } else {
                var inputHtml = '<input type="hidden" id="{id}" name="{name}"/>'.format({
                    id: generateSelectorId(options.selector),
                    name: options.name
                });
                this.$widget = $(inputHtml);
                this.created = false;
            }
            this.formatter = function (position) {
                return wrapFormat(options.formatter, position);
            };
        }

        Field.prototype.render = function (position, hasPicked) {

            var v;
            if (hasPicked) {
                v = this.formatter(position);
            } else {
                v = '';
            }
            console.log(v);
            if (this.$widget.is('input') || this.$widget.is('textarea')) {
                this.$widget.val(v);
            } else if (this.$widget.is('div') || this.$widget.is('td') || this.$widget.is('p')) {
                this.$widget.html(v);
            }
        };

        return Field;

    }());

    var FieldManager = (function () {
        var fields = [];

        function FieldManager() {
            fields = [];
        }

        FieldManager.prototype.addField = function (field) {
            fields.push(field);
        };

        FieldManager.prototype.render = function (position, hasPicked) {
            for (var i = 0.; i < fields.length; i++) {
                fields[i].render(position, hasPicked);
            }

        };

        return FieldManager;

    }());

    // Data Structure End

    function buildBootstrapModalHTML() {
        var toolsHtml = '<div class="btn-group">'
            + '<button id="idAMapPositionPickerLocation" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-map-marker"></span>&nbsp;定位</button>'
            + '<button id="idAMapPositionPickerReset" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-repeat"></span>&nbsp;重置</button>'
            + '<button id="idAMapPositionPickerClear" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span>&nbsp;清除</button>'
            + '<button id="idAMapPositionPickerSearch" type="button" class="btn btn-default btn-sm" data-toggle="collapse" data-target="#idAMapPositionPickerSearchPanel"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>'
            + '</div>';
        var searchPanelHtml = '<div id="idAMapPositionPickerSearchPanel" class="collapse"><input class="form-control input-sm" id="idAMapPositionPickerSearchInput"/><ul id="idAMapPositionPickerSearchResult" class="list-group"></ul></div>';
        var mapPanelHtml = '<div id="idAMapPositionPickerFloatContainer" style="position: absolute;z-index: 2;top:5px;right: 5px;">' + toolsHtml + searchPanelHtml + '</div>';
        var modalHtml = '<div class="modal fade" id="idAMapPositionPickerModal">'
            + '<div class="modal-dialog">'
            + '<div class="modal-content">'
            + '<div class="modal-header"><button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><h4 class="modal-title">请选择地址</h4><small id="idAMapPositionPickerAlert" style="color: red">必须选择一个位置</small></div>'
            + '<div class="modal-body">'
            + '<div id="idAMapPositionPickerMap" style="height: 500px;" class="form-control">'
            + mapPanelHtml
            + '</div>' //End of Map container
            + '<input class="form-control input-sm" style="margin-top:5px;" id="idAMapPositionPickerAddress"/>'
            + '</div>' //End of modal-Body
            + '<div class="modal-footer">'
            + '<button id="idAMapPositionPickerSelect" type="button" class="btn btn-primary btn-sm">确定</button><button id="idAMapPositionPickerCancelBtn" type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>'
            + '</div>' //End of Modal-footer
            + '</div>' //End of Modal-content
            + '</div>' // End of Modal-dialog
            + '</div>';//End of Modal
        return modalHtml;
    }

    var PICKER_CONTROLLER = (function () {
        // Common Modal Controller for all elements

        // Context pick
        var mPicker = null;
        var mapObj = null;

        var isShowOrPickMode = false;

        var $modal = null, $map, $addressInput, $alert, $pickBtn, $locationBtn, $resetBtn, $clearBtn, $cancelBtn;

        // Current picked
        var selectedMarker = null;
        var cachePosition = Position.empty();
        // Search plugin
        var $searchBtn, $searchPanel, $searchInput, $searchResultList;
        var markerList = [];

        var geolocation;


        var mapClickClickHandler = function (e) {
            $alert.hide();
            selectMarker(createMarkerFromLnglat(e.lnglat.lng, e.lnglat.lat));
        };

        function activate(picker) {
            mPicker = picker;
            showModal();
        }

        function deactivate() {
            mPicker = null;
        }

        function showModal() {
            initializeController();
            initializePicker();

            var p = mPicker.position();
            if (p && p.isValid()) {
                selectMarker(createMarkerFromPosition(p));
            } else {
                if (selectedMarker) {
                    selectedMarker.setMap(null);
                }
                $addressInput.val('');
                if (mPicker.opts.center.longitude && mPicker.opts.center.latitude) {
                    mapObj.setCenter(new AMap.LngLat(mPicker.opts.center.longitude, mPicker.opts.center.latitude));
                }
            }
            $modal.modal('show');
        }


        function initializeController() {
            // Initialize global options
            if ($modal == null) {
                $modal = $(buildBootstrapModalHTML());
                $(document.body).append($modal);
                mapObj = new AMap.Map("idAMapPositionPickerMap", {
                    zoom: 15
                });
                AMap.plugin(['AMap.ToolBar', 'AMap.Scale', 'AMap.OverView'],
                    function () {
                        mapObj.addControl(new AMap.ToolBar());
                        mapObj.addControl(new AMap.Scale());
                        mapObj.addControl(new AMap.OverView({isOpen: true}));
                    });
                mapObj.on('click', mapClickClickHandler);
                mapObj.plugin('AMap.Geolocation', function () {
                    geolocation = new AMap.Geolocation({
                        enableHighAccuracy: true,
                        timeout: 3000,
                        maximumAge: 0,
                        convert: true,
                        panToLocation: true,
                        zoomToAccuracy: true,
                        markerOptions: {}
                    });
                });
                // DOM Selectors and events
                $map = $("#idAMapPositionPickerMap");
                $pickBtn = $("#idAMapPositionPickerSelect");
                $locationBtn = $("#idAMapPositionPickerLocation");
                $resetBtn = $("#idAMapPositionPickerReset");
                $clearBtn = $("#idAMapPositionPickerClear");
                $addressInput = $("#idAMapPositionPickerAddress");
                $cancelBtn = $("#idAMapPositionPickerCancelBtn");
                $alert = $("#idAMapPositionPickerAlert");

                $searchBtn = $("#idAMapPositionPickerSearch");
                $searchPanel = $("#idAMapPositionPickerSearchPanel");
                $searchInput = $("#idAMapPositionPickerSearchInput");
                $searchResultList = $("#idAMapPositionPickerSearchResult");

                $pickBtn.on('click', pickPosition);
                $resetBtn.on('click', resetInitialPosition);
                $clearBtn.on('click', clearPosition);
                $locationBtn.on('click', location);
                $searchPanel.on('show.bs.collapse', function () {
                    $searchBtn.removeClass('btn-default').addClass('btn-primary');
                    startSearch();
                }).on('hide.bs.collapse', function () {
                    $searchBtn.removeClass('btn-primary').addClass('btn-default');
                    endSearch();
                });
                $('ul#idAMapPositionPickerSearchResult').on('click', 'li[data-poi-index]', highlightMarker);
            }
        }

        function initializePicker() {
            toggleMode(false);
            $map.css('height', mPicker.opts.height);
            $modal.find('h4.modal-title').html(mPicker.opts.title);
            $alert.hide();

        }

        function location() {
            $alert.hide();
            geolocation.getCurrentPosition(function (status, result) {
                if (status == 'complete') {
                    selectMarker(createMarkerFromLnglat(result.position.lng, result.position.lat, result.formattedAddress))
                } else {
                    $alert.html(result.message).show();
                }
            });
        }

        function clearPosition() {
            cachePosition = Position.empty();
            if (selectedMarker != null) {
                selectedMarker.setMap(null);
            }
            $addressInput.val('');
        }

        function resetInitialPosition() {
            cachePosition = mPicker.getInitialPosition();
            if (Position.validate(cachePosition)) {
                selectMarker(createMarkerFromPosition(cachePosition));
            } else if (selectedMarker != null) {
                selectedMarker.setMap(null);
                $addressInput.val('');
            }
        }

        function isPositionPicked() {
            return cachePosition.isValid();
        }

        function pickPosition() {
            if (isShowOrPickMode) {
                $modal.modal('hide');
                return;
            }
            var address = $addressInput.val();
            cachePosition.address = address;

            // Always use new position instance
            var pickedPosition;
            var hasPicked = isPositionPicked();
            if (hasPicked) {
                pickedPosition = cachePosition.copy();
            } else {
                pickedPosition = Position.empty();
            }

            if (mPicker.opts.required && !hasPicked) {
                $alert.html(mPicker.opts.errorTip).show();
            } else {
                $alert.hide();
                $modal.modal('hide');
                mPicker._onPickedCallback(pickedPosition, hasPicked);
            }
        }

        // Search Start
        function highlightMarker(e) {

            var index = $(this).data('poiIndex');
            if (index < markerList.length) {
                markerList[index].resumeMove();
            }
        }

        function startSearch() {
            mapObj.off('click', mapClickClickHandler);
            $resetBtn.prop('disabled', true);
            $clearBtn.prop('disabled', true);
            $locationBtn.prop('disabled', true);

            $searchInput.on('keydown', function (e) {
                var searchKeyword = $searchInput.val();
                if (e.which == '13' && searchKeyword.length > 0) { //Enter
                    AMap.service('AMap.PlaceSearch', function () {
                        var placeSearch = new AMap.PlaceSearch({
                            pageSize: 6,
                            pageIndex: 1,
                            extensions: 'all' // return full address for POI
                        });
                        // Search in the given bound
                        placeSearch.searchInBounds(searchKeyword, mapObj.getBounds(), function (status, result) {
                            $searchResultList.children('li').remove();
                            for (var i in markerList) {
                                markerList[i].setMap(null);
                            }
                            markerList = [];
                            if (status == 'complete') {
                                for (var i in result.poiList.pois) {
                                    var poi = result.poiList.pois[i];
                                    var li = $('<li data-poi-index="{i}" class="list-group-item"><small>{name}</small></li>'.format({
                                        i: i,
                                        name: poi.name
                                    }));
                                    $searchResultList.append(li);
                                    // delay to username poi.address
                                    var mMarker = createMarkerFromLnglat(poi.location.lng, poi.location.lat);
                                    mMarker.on('click', function (e) {
                                        selectMarker(e.target);
                                    });
                                    markerList.push(mMarker);
                                }
                                mapObj.panTo(markerList[0].getPosition());
                            } else {
                                $searchPanel.append('<li class="list-group-item disabled"><small>抱歉，暂无找到符合条件的结果。</small></li>');
                            }
                        });
                    });
                }
            });
        }

        function endSearch() {
            mapObj.on('click', mapClickClickHandler);
            $resetBtn.prop('disabled', false);
            $clearBtn.prop('disabled', false);
            $locationBtn.prop('disabled', false);
            $searchInput.val('').off('keydown');
            for (var i in markerList) {
                markerList[i].setMap(null);
            }
            markerList = [];
            $searchResultList.children('li').remove();
        }

        // Search End


        // New tools

        function createMarkerFromPosition(position) {
            var markerOpts = {
                map: mapObj,
                position: new AMap.LngLat(position.longitude, position.latitude),
                topWhenClick: true,
                offset: new AMap.Pixel(-5, -30),
                animation: 'AMAP_ANIMATION_DROP',
                extData: position
            };
            if (position.address) {
                markerOpts.title = position.address;
            }
            var marker = new AMap.Marker(markerOpts);
            return marker;
        }

        function createMarkerFromLnglat(longitude, latitude, address) {
            var position = new Position(longitude, latitude, address, "");
            return createMarkerFromPosition(position);
        }

        function selectMarker(marker) {
            clearPosition();
            selectedMarker = marker;
            var position = marker.getExtData();
            var lngLat = marker.getPosition();

            cachePosition.longitude = position.longitude;
            cachePosition.latitude = position.latitude;
            if (!position.address) {
                var geocoder;
                mapObj.plugin(["AMap.Geocoder"], function () {
                    geocoder = new AMap.Geocoder({
                        radius: 1000,
                        extensions: "base"
                    });
                    AMap.event.addListener(geocoder, "complete", function (GeocoderResult) {
                        if (GeocoderResult["info"] == "OK") {
                            var address = GeocoderResult.regeocode.formattedAddress;
                            position.address = address;
                            selectedMarker.setExtData(position);
                            cachePosition.address = address;
                            $addressInput.val(address);
                            mapObj.panTo(lngLat);
                        }
                    });
                    geocoder.getAddress(lngLat);
                });
            } else {
                cachePosition.address = position.address;
                mapObj.panTo(lngLat);
                $addressInput.val(position.address);
            }
        }

        // End Tool functions

        function toggleMode(isShowOrPick) {
            isShowOrPickMode = isShowOrPick;

            $addressInput.prop('readonly', isShowOrPick);
            if (isShowOrPick) {
                mapObj.off('click', mapClickClickHandler);
                $cancelBtn.hide();
                $alert.hide();
                $('#idAMapPositionPickerFloatContainer').hide();
            } else {
                mapObj.on('click', mapClickClickHandler);
                $('#idAMapPositionPickerFloatContainer').show();
                $cancelBtn.show();
            }

        }

        function showPositionInMap(position) {
            initializeController();
            toggleMode(true);
            clearPosition();
            var mMarker = createMarkerFromPosition(position);
            mapObj.panTo(mMarker.getPosition());
            $modal.find('h4.modal-title').html(position.getDisplayString());
            $addressInput.val(position.address);
            $modal.modal('show');

        }

        return {
            activate: activate,
            deactivate: activate,
            //Tools
            showPositionInMap: showPositionInMap
        }
    })();

    var aMapPositionPicker = function (element, options) {

        var picker = {
            isFirstLoad: false,
            initialPosition: null,
            fieldManager: new FieldManager()
        };
        var $inputEl = null;

        function triggerPickedComplete(mPosition, hasPicked) {
            if (options.onPicked) {
                options.onPicked(mPosition)
            } else {
                element.trigger('AMPP.PickCompleted', [mPosition, hasPicked]);
            }
        }

        // API for PICKER_CONTROLLER
        picker._onPickedCallback = function (mPosition, hasPicked) {
            element.data('position', mPosition);
            $inputEl.val(wrapFormat(options.formatter, mPosition));
            picker.fieldManager.render(mPosition, hasPicked);
            triggerPickedComplete(mPosition, hasPicked);
        };

        // Public API

        picker.getInitialPosition = function () {
            return initialPosition;
        };

        picker.position = function () {
            var s = JSON.stringify(element.data('position'));
            return element.data('position');

        };

        //
        if (element.is('input') || element.is('textarea')) {
            $inputEl = element;
        } else {
            $inputEl = element.children('input');
        }
        $inputEl.prop("readonly", true);
        //Handle initial data
        if (Position.LNGLAT_FORMATTER.indexOf(options.formatter)) {
            var result = Position.validateLngLat($inputEl.val());
            if (result) {
                options.value.longitude = parseFloat(result.longitude);
                options.value.latitude = parseFloat(result.latitude);
            }
        }
        var initialPosition = new Position(options.value.longitude, options.value.latitude, options.value.address, options.value.label);
        element.data('position', initialPosition.copy());
        // Register events
        element.on('click', function () {
            //show modal/
            PICKER_CONTROLLER.activate(picker);
        });
        // 处理fields
        var fields = options.fields || [];
        for (var i in fields) {
            var iEl = new Field(fields[i] || {});
            if (!iEl.created) {
                $inputEl.after(iEl.$widget);
            }
            picker.fieldManager.addField(iEl);
        }

        picker.opts = options;
        return picker;
    };

    $.fn.AMapPositionPicker = function (options) {
        options = options || {};
        var args = Array.prototype.slice.call(arguments, 1),
            isInstance = true,
            thisMethods = [], //可级联函数列表
            returnValue;
        if (typeof  options == 'object') {
            return this.each(function () {
                var $this = $(this);
                if (!$this.data('AMapPositionPicker')) {
                    var dataOptions = {
                        formatter: $this.data('formatter'),
                        title: $this.data('title'),
                        errorTip: $this.data('errorTip'),
                        height: $this.data('height'),
                        required: $this.data('required'),
                        value: {
                            longitude: $this.data('valueLongitude'),
                            latitude: $this.data('valueLatitude'),
                            address: $this.data('valueAddress'),
                            label: $this.data('valueLabel')
                        },
                        center: {
                            longitude: $this.data('centerLongitude'),
                            latitude: $this.data('centerLatitude')
                        }
                    };
                    options = $.extend(true, {}, $.fn.AMapPositionPicker.defaults, dataOptions, options);
                    $this.data('AMapPositionPicker', aMapPositionPicker($this, options));
                }
            });
        } else if (typeof  options == 'string') {
            this.each(function () {
                var $this = $(this),
                    instance = $this.data('AMapPositionPicker');
                if (!instance) {
                    throw new Error('AMapPositionPicker("' + options + '") method was called on an element that is not using AMapPositionPicker');
                }
                returnValue = instance[options].apply(instance, args);
                isInstance = returnValue === instance;
            });
            if (isInstance || $.inArray(options, thisMethods) > -1) {
                return this;
            }

            return returnValue;
        }
        throw new TypeError('Invalid arguments for AMapPositionPicker: ' + options);
    };
    $.fn.AMapPositionPicker.defaults = {
        formatter: '{address}',
        onPicked: null,
        value: {
            longitude: null,
            latitude: null,
            address: null
        },
        required: true,
        title: '请选择地址',
        errorTip: '请选择地址',
        height: '500px',
        fields: []
    };
    $.extend({AMapPositionPicker: {}});
    $.extend($.AMapPositionPicker, {
        showPositionInMap: function (position) {
            PICKER_CONTROLLER.showPositionInMap(Position.fromOptions(position));
        },
        pluginVersion: '0.8.3'
    });
    $(function () {
        $('[data-provide="AMapPositionPicker"]').AMapPositionPicker();
    });
}))
;