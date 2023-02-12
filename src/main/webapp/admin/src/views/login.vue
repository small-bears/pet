<template>
  <div>
    <div class="container loginIn" style="backgroundImage: url(http://codegen.caihongy.cn/20201223/72a1e0e0cd6a467ea781956764818af0.jpg)">

      <div :class="2 == 1 ? 'left' : 2 == 2 ? 'left center' : 'left right'" style="backgroundColor: rgba(206, 221, 207, 0.4)">
        <el-form class="login-form" label-position="left" :label-width="2 == 3 ? '56px' : '0px'">
          <div class="title-container"><h3 class="title" style="color: rgba(31, 147, 255, 0.73)">宠物管理系统登录</h3></div>
          <el-form-item :label="2 == 3 ? '用户名' : ''" :class="'style'+2">
            <span v-if="2 != 3" class="svg-container" style="color:rgba(16, 17, 17, 1);line-height:44px"><svg-icon icon-class="user" /></span>
            <el-input placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username" />
          </el-form-item>
          <el-form-item :label="2 == 3 ? '密码' : ''" :class="'style'+2">
            <span v-if="2 != 3" class="svg-container" style="color:rgba(16, 17, 17, 1);line-height:44px"><svg-icon icon-class="password" /></span>
            <el-input placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password" />
          </el-form-item>
          <el-form-item v-if="0 == '1'" class="code" :label="2 == 3 ? '验证码' : ''" :class="'style'+2">
            <span v-if="2 != 3" class="svg-container" style="color:rgba(16, 17, 17, 1);line-height:44px"><svg-icon icon-class="code" /></span>
            <el-input placeholder="请输入验证码" name="code" type="text" v-model="rulesForm.code" />
            <div class="getCodeBt" @click="getRandCode(4)" style="height:44px;line-height:44px">
              <span v-for="(item, index) in codes" :key="index" :style="{color:item.color,transform:item.rotate,fontSize:item.size}">{{ item.num }}</span>
            </div>
          </el-form-item>
          <el-form-item label="角色" prop="loginInRole" class="role">
            <el-radio
              v-for="item in menus"
	      v-if="item.hasBackLogin=='是'"
              v-bind:key="item.roleName"
              v-model="rulesForm.role"
              :label="item.roleName"
            >{{item.roleName}}</el-radio>
          </el-form-item>
          <el-button type="primary" @click="login()" class="loginInBt" style="padding:0;font-size:16px;border-radius:22px;height:44px;line-height:44px;width:100%;backgroundColor:rgba(64, 158, 255, 1); borderColor:rgba(64, 158, 255, 1); color:rgba(255, 255, 255, 1)">{{'1' == '1' ? '登录' : 'login'}}</el-button>
          <el-form-item class="setting">
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        <!-- <div style="color:rgba(153, 153, 153, 1)" class="reset">修改密码</div> -->
          </el-form-item>
        </el-form>
      </div>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;
  },
  created() {
    this.setInputColor()
    this.getRandCode()
  },
  methods: {
    setInputColor(){
      this.$nextTick(()=>{
        document.querySelectorAll('.loginIn .el-input__inner').forEach(el=>{
          el.style.backgroundColor = "rgba(255, 255, 255, 1)"
          el.style.color = "rgba(20, 21, 21, 0.91)"
          el.style.height = "44px"
          el.style.lineHeight = "44px"
          el.style.borderRadius = "22px"
        })
        document.querySelectorAll('.loginIn .style3 .el-form-item__label').forEach(el=>{
          el.style.height = "44px"
          el.style.lineHeight = "44px"
        })
        document.querySelectorAll('.loginIn .el-form-item__label').forEach(el=>{
          el.style.color = "rgba(16, 17, 17, 1)"
        })
        setTimeout(()=>{
          document.querySelectorAll('.loginIn .role .el-radio__label').forEach(el=>{
            el.style.color = "#fff"
          })
        },350)
      })

    },
    register(tableName){
      this.$storage.set("loginTable", tableName);
      this.$router.push({path:'/register'})
    },
    // 登陆
    login() {
      let code = ''
      for(let i in this.codes) {
        code += this.codes[i].num
      }
	  if ('0' == '1' && !this.rulesForm.code) {
	     this.$message.error("请输入验证码");
	    return;
	  }
      if ('0' == '1' && this.rulesForm.code.toLowerCase() != code.toLowerCase()) {
         this.$message.error("验证码输入有误");
		this.getRandCode()
        return;
      }
      if (!this.rulesForm.username) {
         this.$message.error("请输入用户名");
        return;
      }
      if (!this.rulesForm.password) {
         this.$message.error("请输入密码");
        return;
      }
      if (!this.rulesForm.role) {
         this.$message.error("请选择角色");
        return;
      }
      let menus = this.menus;
      for (let i = 0; i < menus.length; i++) {
        if (menus[i].roleName == this.rulesForm.role) {
          this.tableName = menus[i].tableName;
        }
      }
      this.$http({
        url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
        method: "post"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$storage.set("Token", data.token);
          this.$storage.set("role", this.rulesForm.role);
          this.$storage.set("sessionTable", this.tableName);
          this.$storage.set("adminName", this.rulesForm.username);
          this.$router.replace({ path: "/index/" });
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    getRandCode(len = 4){
      this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
};
</script>
<style lang="scss" scoped>
.loginIn {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;

  .left {
    position: absolute;
    left: 0;
    top: 0;
    width: 360px;
    height: 100%;

    .login-form {
      background-color: transparent;
      width: 100%;
      right: inherit;
      padding: 0 12px;
      box-sizing: border-box;
      display: flex;
      justify-content: center;
      flex-direction: column;
    }

    .title-container {
      text-align: center;
      font-size: 24px;

      .title {
        margin: 20px 0;
      }
    }

    .el-form-item {
      position: relative;

      .svg-container {
        padding: 6px 5px 6px 15px;
        color: #889aa4;
        vertical-align: middle;
        display: inline-block;
        position: absolute;
        left: 0;
        top: 0;
        z-index: 1;
        padding: 0;
        line-height: 40px;
        width: 30px;
        text-align: center;
      }

      .el-input {
        display: inline-block;
        height: 40px;
        width: 100%;

        & /deep/ input {
          background: transparent;
          border: 0px;
          -webkit-appearance: none;
          padding: 0 15px 0 30px;
          color: #fff;
          height: 40px;
        }
      }

    }


  }

  .center {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 360px;
    transform: translate3d(-50%,-50%,0);
    height: 446px;
    border-radius: 8px;
  }

  .right {
    position: absolute;
    left: inherit;
    right: 0;
    top: 0;
    width: 360px;
    height: 100%;
  }

  .code {
    .el-form-item__content {
      position: relative;

      .getCodeBt {
        position: absolute;
        right: 0;
        top: 0;
        line-height: 40px;
        width: 100px;
        background-color: rgba(51,51,51,0.4);
        color: #fff;
        text-align: center;
        border-radius: 0 4px 4px 0;
        height: 40px;
        overflow: hidden;

        span {
          padding: 0 5px;
          display: inline-block;
          font-size: 16px;
          font-weight: 600;
        }
      }

      .el-input {
        & /deep/ input {
          padding: 0 130px 0 30px;
        }
      }
    }
  }

  .setting {
    & /deep/ .el-form-item__content {
      padding: 0 15px;
      box-sizing: border-box;
      line-height: 32px;
      height: 32px;
      font-size: 14px;
      color: #999;
      margin: 0 !important;

      .register {
        float: left;
        width: 50%;
      }

      .reset {
        float: right;
        width: 50%;
        text-align: right;
      }
    }
  }

  .style2 {
    padding-left: 30px;

    .svg-container {
      left: -30px !important;
    }

    .el-input {
      & /deep/ input {
        padding: 0 15px !important;
      }
    }
  }

  .code.style2, .code.style3 {
    .el-input {
      & /deep/ input {
        padding: 0 115px 0 15px;
      }
    }
  }

  .style3 {
    & /deep/ .el-form-item__label {
      padding-right: 6px;
    }

    .el-input {
      & /deep/ input {
        padding: 0 15px !important;
      }
    }
  }

  .role {
    & /deep/ .el-form-item__label {
      width: 56px !important;
    }

    & /deep/ .el-radio {
      margin-right: 12px;
    }
  }

}
</style>
