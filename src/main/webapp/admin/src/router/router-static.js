import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discusschongwulingyang from '@/views/modules/discusschongwulingyang/list'
    import discusschongwushangdian from '@/views/modules/discusschongwushangdian/list'
    import discusschongwuguashi from '@/views/modules/discusschongwuguashi/list'
    import storeup from '@/views/modules/storeup/list'
    import chongwuyongpin from '@/views/modules/chongwuyongpin/list'
    import users from '@/views/modules/users/list'
    import chongwufenlei from '@/views/modules/chongwufenlei/list'
    import forum from '@/views/modules/forum/list'
    import yonghulingyang from '@/views/modules/yonghulingyang/list'
    import chongwulingyang from '@/views/modules/chongwulingyang/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import chongwushangdian from '@/views/modules/chongwushangdian/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import orders from '@/views/modules/orders/list'
    import chongwujicun from '@/views/modules/chongwujicun/list'
    import chongwuguashi from '@/views/modules/chongwuguashi/list'
    import config from '@/views/modules/config/list'
    import discusschongwuyongpin from '@/views/modules/discusschongwuyongpin/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/news',
        name: '宠物资讯',
        component: news
      }
          ,{
	path: '/discusschongwulingyang',
        name: '宠物领养评论',
        component: discusschongwulingyang
      }
          ,{
	path: '/discusschongwushangdian',
        name: '宠物商店评论',
        component: discusschongwushangdian
      }
          ,{
	path: '/discusschongwuguashi',
        name: '宠物挂失评论',
        component: discusschongwuguashi
      }
          ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
          ,{
	path: '/chongwuyongpin',
        name: '宠物用品',
        component: chongwuyongpin
      }
          ,{
	path: '/users',
        name: '管理员',
        component: users
      }
          ,{
	path: '/chongwufenlei',
        name: '宠物分类',
        component: chongwufenlei
      }
          ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
          ,{
	path: '/yonghulingyang',
        name: '用户领养',
        component: yonghulingyang
      }
          ,{
	path: '/chongwulingyang',
        name: '宠物领养',
        component: chongwulingyang
      }
          ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
          ,{
	path: '/chongwushangdian',
        name: '宠物商店',
        component: chongwushangdian
      }
          ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
          ,{
	path: '/chat',
        name: '客服管理',
        component: chat
      }
          ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
          ,{
	path: '/chongwujicun',
        name: '宠物寄存',
        component: chongwujicun
      }
          ,{
	path: '/chongwuguashi',
        name: '宠物挂失',
        component: chongwuguashi
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
          ,{
	path: '/discusschongwuyongpin',
        name: '宠物用品评论',
        component: discusschongwuyongpin
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
