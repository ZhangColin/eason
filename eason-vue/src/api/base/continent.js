import request from '@/utils/request'

export function findContinents() {
  return request({
    url: '/base/continent',
    method: 'get'
  })
}
