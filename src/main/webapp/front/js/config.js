
var projectName = '宠物管理系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
	name: '我的订单',
	url: '../shop-order/list.html'
},

{
	name: '我的地址',
	url: '../shop-address/list.html'
},

{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '宠物用品',
	url: './pages/chongwuyongpin/list.html'
}, 
{
	name: '宠物商店',
	url: './pages/chongwushangdian/list.html'
}, 
{
	name: '宠物领养',
	url: './pages/chongwulingyang/list.html'
}, 
{
	name: '宠物挂失',
	url: './pages/chongwuguashi/list.html'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.html'
}, 
{
	name: '宠物资讯',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/ssmqj7b0/admin/dist/index.html";

var cartFlag = false

var chatFlag = false


chatFlag = true
cartFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"宠物分类","menuJump":"列表","tableName":"chongwufenlei"}],"menu":"宠物分类管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"商品分类","menuJump":"列表","tableName":"shangpinfenlei"}],"menu":"商品分类管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"宠物用品","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"宠物商店","menuJump":"列表","tableName":"chongwushangdian"}],"menu":"宠物商店管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"宠物领养","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"宠物寄存","menuJump":"列表","tableName":"chongwujicun"}],"menu":"宠物寄存管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"用户领养","menuJump":"列表","tableName":"yonghulingyang"}],"menu":"用户领养管理"},{"child":[{"buttons":["查看","修改","删除","查看评论"],"menu":"宠物挂失","menuJump":"列表","tableName":"chongwuguashi"}],"menu":"宠物挂失管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"论坛管理","tableName":"forum"}],"menu":"论坛管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"管理员","tableName":"users"}],"menu":"管理员管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"buttons":["新增","查看","修改","删除"],"menu":"宠物资讯","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"客服管理","tableName":"chat"}],"menu":"系统管理"},{"child":[{"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},{"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},{"buttons":["查看"],"menu":"已发货订单","tableName":"orders/已发货"},{"buttons":["查看"],"menu":"未支付订单","tableName":"orders/未支付"},{"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},{"buttons":["查看","发货"],"menu":"已支付订单","tableName":"orders/已支付"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"宠物用品列表","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品模块"},{"child":[{"buttons":["查看","宠物寄存"],"menu":"宠物商店列表","menuJump":"列表","tableName":"chongwushangdian"}],"menu":"宠物商店模块"},{"child":[{"buttons":["查看","申请领养"],"menu":"宠物领养列表","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养模块"},{"child":[{"buttons":["新增","查看"],"menu":"宠物挂失列表","menuJump":"列表","tableName":"chongwuguashi"}],"menu":"宠物挂失模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看"],"menu":"宠物寄存","menuJump":"列表","tableName":"chongwujicun"}],"menu":"宠物寄存管理"},{"child":[{"buttons":["查看","支付"],"menu":"用户领养","menuJump":"列表","tableName":"yonghulingyang"}],"menu":"用户领养管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"宠物挂失","menuJump":"列表","tableName":"chongwuguashi"}],"menu":"宠物挂失管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"},{"child":[{"buttons":["查看"],"menu":"已支付订单","tableName":"orders/已支付"},{"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},{"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},{"buttons":["查看","确认收货"],"menu":"已发货订单","tableName":"orders/已发货"},{"buttons":["查看"],"menu":"未支付订单","tableName":"orders/未支付"},{"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"宠物用品列表","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品模块"},{"child":[{"buttons":["查看","宠物寄存"],"menu":"宠物商店列表","menuJump":"列表","tableName":"chongwushangdian"}],"menu":"宠物商店模块"},{"child":[{"buttons":["查看","申请领养"],"menu":"宠物领养列表","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养模块"},{"child":[{"buttons":["新增","查看"],"menu":"宠物挂失列表","menuJump":"列表","tableName":"chongwuguashi"}],"menu":"宠物挂失模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
