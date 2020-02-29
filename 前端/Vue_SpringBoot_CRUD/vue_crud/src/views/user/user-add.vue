<template>
  <div style="width: 400px">
    <el-form ref="form" :model="user" label-width="80px">
      <el-form-item label="用户姓名">
        <el-input v-model="user.userName"></el-input>
      </el-form-item>

      <el-form-item label="性别">
        <el-radio-group v-model="user.userSex">
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">女</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="年龄">
        <el-input v-model="user.userAge"></el-input>
      </el-form-item>

      <el-form-item label="出生日期">
        <el-col :span="11">
          <el-date-picker
            type="date"
            placeholder="选择日期"
            v-model="user.userBirthday"
            value-format= 'yyyy-MM-dd'
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
      </el-form-item>

      <el-form-item label="部门">
        <el-select v-model="user.userDepartment" placeholder="请选择部门">
          <el-option 
          v-for="item in departmentList" 
          :key="item.id" 
          :label="item.name"
          :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveUser">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import userApi from "@/api/user";
export default {
  data() {
    return {
      departmentList: this.$store.getters.getDepartmentList,
      user: {}
    };
  },
  methods: {
    saveUser() {
      userApi.save(this.user).then(res =>{
        this.$message.success(res.msg)
        this.$router.push("/userList")
      })
    }
  }
};
</script>

<style scoped>
.page-component {
  margin-top: 15px;
  text-align: center;
}
</style>