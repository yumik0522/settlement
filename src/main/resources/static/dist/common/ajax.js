var qs = function (data) {
  let url = ''
  for (var k in data) {
    let value = data[k] !== undefined ? data[k] : ''
    url += '&' + k + '=' + encodeURIComponent(value)
  }
  return url ? url.substring(1) : ''
}

var token = sessionStorage.getItem("token");
if(!token) {
	token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJ1c2VyaWRcIjoxfSIsImp0aSI6ImFkOTg2ZGQ2MTVkMzQ3Mzc5ZmQ1MWVlZDViNTkwYzE4IiwiZXhwIjoxNTY2MDU3NjAwLCJpYXQiOjE1NjM1MjY2Nzh9.Fu7F1IhizcRWyjp3Zrvho2mMJC9y9k6FjlYyZea4S3I";
}
var AUTH_TOKEN = token?"Bearer "+token:"";   
axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

var post = function(url,data,callback,errorFun) {
	axios.post(url,qs(data)).then(function (response) {
		if(loginOut(response.data)) {
			callback(response.data);
		}
		
	}).catch(function(error){
		if(errorFun) {
			errorFun(error);
		}
		console.log(error);
	});
}


var get = function(url,callback) {
	axios.get(url).then(function (response) {
		callback(response);
	}).catch(function(error){
		console.log(error);
	});
}

function loginOut(t) {
	if(t.code==3000001||(t.code==3000000&&t.msg=='登录已过期')) {
		//location.href = '/login';
	} else {
		return true;
	}
}