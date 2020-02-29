<template>
  <div>
    <!-- 查询 -->
    <el-form :inline="true" :model="user" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="user.userName" placeholder="姓名"></el-input>
      </el-form-item>

      <el-form-item label="性别">
        <el-select v-model="user.userSex" placeholder="请选择">
          <el-option label="男" value="1"></el-option>
          <el-option label="女" value="2"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="部门">
        <el-select v-model="user.userDepartment" placeholder="请选择">
          <el-option
            v-for="item in departmentList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="生日">
        <div class="block">
          <el-date-picker
            v-model="Birthday"
            format="yyyy-MM-dd"
            value-format="yyyy-MM-dd"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            @change="changeBirthday"
          ></el-date-picker>
        </div>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="getUser">查询</el-button>
      </el-form-item>
    </el-form>

    <!-- 表格 -->
    <el-table :data="pageInfo.list" border style="width: 100%" @sort-change="sortChange">
      <el-table-column prop="userId" label="编号" sortable="custom"></el-table-column>
      <el-table-column prop="userName" label="姓名" sortable="custom"></el-table-column>
      <el-table-column prop="userSex" label="性别" sortable="custom">
        <template slot-scope="scope">
          <span>{{ scope.row.userSex === 1 ? '男':'女' }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="userAge" label="年龄" sortable="custom"></el-table-column>
      <el-table-column prop="userBirthday" label="出生日期" sortable="custom">
        <template slot-scope="scope">
          <span>{{ scope.row.userBirthday | handlerNullTime }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="department.name" label="部门" sortable="custom"></el-table-column>
      <el-table-column prop="createdTime" label="创建时间" sortable="custom">
        <template slot-scope="scope">
          <span>{{ scope.row.createdTime | handlerNullTime }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="updateTime" label="修改时间" sortable="custom">
        <template slot-scope="scope">
          <span>{{ scope.row.updateTime | handlerNullTime }}</span>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button
            @click="toUpdate(scope.row.userId)"
            type="primary"
            icon="el-icon-edit"
            size="small"
            circle
          ></el-button>
          <el-button
            @click="deleteById(scope.row.userId)"
            type="danger"
            icon="el-icon-delete"
            size="small"
            circle
          ></el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页条 -->
    <div class="page-component">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="this.pageNum"
        :page-sizes="[1,2,5,10]"
        :page-size="this.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="pageInfo.total"
      ></el-pagination>
    </div>

    <!-- 修改用户弹窗 -->
    <el-dialog title="更新用户" :visible.sync="dialogFormVisible">
      <user-edit :user="user" @closeDialog="closeDialog" @getUserList="getUserList"></user-edit>
    </el-dialog>
  </div>
</template>

<script>
import userApi from "@/api/user";
import UserEdit from "./user-edit.vue";
export default {
  data() {
    return {
      pageInfo: [],
      pageSize: 5,
      pageNum: 1,
      user: {},
      departmentList: this.$store.getters.getDepartmentList,
      Birthday: null,
      dialogFormVisible: false
    };
  },
  components: {
    UserEdit
  },
  methods: {
    getUserList() {
      this.user = {};
      userApi.userList(this.pageNum, this.pageSize, this.user).then(res => {
        // 调用 user.js 的 userList 方法，res 接收结果
        this.pageInfo = res.data;
      });
    },
    changeBirthday(val) {
      if (val) {
        this.user.userBirthdayStart = val[0];
        this.user.userBirthdayEnd = val[1];
      } else {
        this.user.userBirthdayStart = null;
        this.user.userBirthdayEnd = null;
      }
    },
    handleSizeChange(val) {
      // 每页显示条数修改 触发
      this.pageSize = val;
      this.getUserList();
    },
    handleCurrentChange(val) {
      // 翻页 触发
      this.pageNum = val;
      this.getUserList();
    },
    getUser() {
      this.getUserList();
    },
    sortChange(column, prop, order) {
      this.user.sortColumn = column.prop;
      this.user.sortMethod = column.order;
      this.getUserList();
    },
    toUpdate(userId) {
      userApi.getById(userId).then(res => {
        this.user = res.data;
        this.dialogFormVisible = true;
      });
    },
    closeDialog() {
      this.dialogFormVisible = false;
    },
    deleteById(userId) {
      this.$confirm("是否删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        userApi.deleteById(userId).then(res => {
          this.$message.success(res.msg);
          this.getUserList();
        });
      });
    }
  },
  filters: {
    handlerNullTime(time) {
      if (!time) {
        return "无";
      }
      return time.slice(0, 10);
    }
  },
  created() {
    this.getUserList();
  }
};
</script>

<style scoped>
.page-component {
  margin-top: 15px;
  text-align: center;
}
</style>