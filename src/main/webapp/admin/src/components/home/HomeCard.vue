<template>
  <el-card class="box-card">
    <div slot="header" class="header">
      <span>{{title}}</span>
      <span>
        <el-tag size="small" :type="titleTag">{{titleUnit}}</el-tag>
      </span>
    </div>
    <div class="content">
      {{content}}&nbsp;&nbsp;
      <span class="unit">{{contentUnit}}</span>
    </div>
    <div class="bottom">
      <span>{{bottomTitle}}</span>
      <span>
        {{bottomContent}}
        <i :class="bottomIcon"></i>
      </span>
    </div>
  </el-card>
</template>
<script>
export default {
  props: [
    "title",
    "titleTag",
    "titleUnit",
    "content",
    "contentUnit",
    "bottomTitle",
    "bottomContent",
    "bottomIcon"
  ]
};
</script>
<style lang="scss" scoped>
.box-card {
  margin-right: 10px;
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  .content {
    font-size: 30px;
    font-weight: bold;
    color: #666;
    text-align: center;
    .unit {
      font-size: 16px;
    }
  }
  .bottom {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 10px;
  }
}
</style>
