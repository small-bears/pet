<template>
  <div class="content">
    <img class="backgroud" src="@/assets/img/404.png" alt>
    <div class="text main-text">出错了...页面失踪了</div>
    <div>
      <el-button class="text" @click="back()" type="text" icon="el-icon-back">返回</el-button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    back() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push("/");
    }
  }
};
</script>

<style lang="scss" scoped>
.content {
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 900px;
  text-align: center;
  .backgroud {
    display: inline-block;
    width: 200px;
    height: 200px;
    margin-top: 80px;
  }
  .main-text{
    margin-top: 80px;
  }
  .text {
    font-size: 24px;
    font-weight: bold;
    color: #333;
  }
}
</style>

