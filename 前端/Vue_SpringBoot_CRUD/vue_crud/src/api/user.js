import request from '@/utils/request'
const group_name = 'user'
export default {
  userList(pageNum, pageSize, user) {
    return request({
      url: `/${group_name}/page?pageNum=${pageNum}&pageSize=${pageSize}`,
      method: 'post',
      data: user
    })
  },
  update(user) {
    return request({
      url: `/${group_name}/update`,
      method: 'put',
      data: user
    })
  },
  deleteById(id) {
    return request({
      url: `/${group_name}/delete/${id}`,
      method: 'delete'
    })
  },
  save(user) {
    return request({
      url: `/${group_name}/save`,
      method: 'post',
      data: user
    })
  },
  getById(id) {
    return request({
      url: `/${group_name}/get/${id}`,
      method: 'get'
    })
  },
}