/**
 * 邮箱
 * @param {*} s
 */
function isEmail(s) {
	if(s){
		return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
	}
	return true;
}

/**
 * 手机号码
 * @param {*} s
 */
function isMobile(s) {
	if(s){
		return /^1[0-9]{10}$/.test(s)
	}
	return true;
}

/**
 * 电话号码
 * @param {*} s
 */
function isPhone(s) {
	if(s){
		return /^([0-9]{3,4}-)?[0-9]{7,8}$/.test(s)
	}
	return true;
}

/**
 * URL地址
 * @param {*} s
 */
function isURL(s) {
	if(s){
		return /^http[s]?:\/\/.*/.test(s)
	}
	return true;
}

/**
 * 匹配数字，可以是小数，不可以是负数,可以为空
 * @param {*} s 
 */
function isNumber(s) {
	if(s){
		return /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/.test(s);
	}
	return true;
}
/**
 * 匹配整数，可以为空
 * @param {*} s 
 */
function isIntNumer(s) {
	if(s){
		return /(^-?\d+$)|(^$)/.test(s);
	}
	return true;
}
/**
 * 身份证校验
 */
function isIdentity(idcard) {
	const regIdCard = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	if(idcard){
		return regIdCard.test(idcard);
	}
	return true;
}
