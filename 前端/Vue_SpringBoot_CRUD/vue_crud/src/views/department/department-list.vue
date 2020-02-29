<template>
  <div>
    <el-table :data="departmentList" border style="width: 100%">
      <el-table-column prop="id" label="部门编号"></el-table-column>
      <el-table-column prop="name" label="部门名称"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import departmentApi from "@/api/department.js";
export default {
  data() {
    return {
      departmentList: []
    }
  },
  methods: {
    getDepartmentList() {
      departmentApi.departmentList().then(res => {
        // 调用 department.js 的 departmentList 方法，res 接收结果
        this.departmentList = res.data
      })
    }
  },
  created() {
    this.getDepartmentList();
  }
}
</script>