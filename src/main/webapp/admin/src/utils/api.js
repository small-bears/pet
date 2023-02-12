const api = {
    // 客服
    chatpage:'chat/page?sort=addtime&order=desc&isreply=1',
    chatbyuseridpage: 'chat/page?sort=addtime&order=desc&userid=',
    chatsave: 'chat/save',
    // 积分订单
    orderpage: 'orders/page',
    orderdelete: 'orders/delete',
    orderinfo: 'orders/info/',
    ordersave: 'orders/save',
    orderupdate: 'orders/update',
    // 配置
    configpage: 'config/page',
    configdelete: 'config/delete',
    configinfo: 'config/info/',
    configsave: 'config/save',
    configupdate: 'config/update'

}

export default api
