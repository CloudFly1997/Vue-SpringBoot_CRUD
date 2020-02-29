import request from '@/utils/request'
const group_name = 'department'
export default {
  departmentList() {
    return request({
      url: `/${group_name}/departmentList`,
      method: 'get'
    })
  }
}
