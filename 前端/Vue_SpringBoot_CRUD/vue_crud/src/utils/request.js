import axios from 'axios'
import { Message } from 'element-ui'
const service = axios.create({
  baseURL: '/',
  timeout: 5000 // 默认请求超时时间
})

/**
 * request 拦截器
 * 可以在请求发送前对请求进行一些处理
 * 如：统一在请求头上加上token
 * 对请求参数进行统一加密
 * 等等
 */
service.interceptors.request.use(
  config => {
    return config
  },
  error => {
    // 请求异常了
    Message({
      type: 'error',
      message: '系统异常，请及时联系管理员'
    })
    return Promise.reject(error)
  }
)

/**
 * response 拦截器
 * 可以在接口响应之后，页面获取到响应结果之前
 * 对响应结果统一进行处理
 * 如：对返回结果进行解密 
 */
service.interceptors.response.use(
  response => {
    const res = response.data
    if (res.code === 200) {
      // code是200的情况，表示接口是通的，直接返回res
      return res
    } else {
      // else：非200的情况，表示接口异常
      Message({
        type: 'error',
        message: res.msg
      })
    }
  },
  error => {
    // 请求报错的情况下（http请求报错）
    Message({
      type: 'error',
      message: res.msg
    })
  }
)

export default service
