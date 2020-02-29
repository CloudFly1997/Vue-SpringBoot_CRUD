<template>
  <div>
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
            value-format="yyyy-MM-dd"
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
    </el-form>

    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="updateUser">修改</el-button>
    </div>
  </div>
</template>

<script>
import userApi from "@/api/user";
export default {
  data() {
    return {
      departmentList: this.$store.getters.getDepartmentList,
    };
  },
  props: {
    user: {
      type: Object,
      default: {}
    }
  },
  methods: {
    updateUser() {
      userApi.update(this.user).then(res => {
        this.$message.success(res.msg);
        this.$emit('closeDialog');
        this.$emit('getUserList');
      });
    }
  }
};
</script>