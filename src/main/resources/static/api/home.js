define(["text!../components/home.html","css!../css/home.css"], function(template) {
    return {
        template:template,
        data() {
			return {
				sysName:'财务结算',
				isCollapse:true,
				username: 'admin',
				sysUserAvatar: '/static/images/0.jpg',
				defaultMenu:'project',
				activeName:"runningTasks",
				form: {
					name: '',
					region: '',
					date1: '',
					date2: '',
					delivery: false,
					type: [],
					resource: '',
					desc: ''
				},
				runningList:[],
				finishedList:[],
				rotate:'',
				jobnum:'',
				screen:'full',
				menus:[]
			}
		},
		mounted:function(){
        	this.listMenu();
        },
		methods: {
			collapse() {
				this.isCollapse = !this.isCollapse;
			},
			selectMenu(index){
				this.defaultMenu = index;
			},fullScreen: function() {
				
	            var e = document.documentElement
	              , a = e.requestFullScreen || e.webkitRequestFullScreen || e.mozRequestFullScreen || e.msRequestFullscreen;
	            "undefined" != typeof a && a && a.call(e)
	            this.screen='exit';
	        },exitScreen: function() {
	            document.documentElement;
	            let aa = document.exitFullscreen ? document.exitFullscreen() : document.mozCancelFullScreen ? document.mozCancelFullScreen() : document.webkitCancelFullScreen ? document.webkitCancelFullScreen() : document.msExitFullscreen && document.msExitFullscreen();
	            this.screen='full';
	        },listMenu() {
	        	let target = this;
	        	let res = {
      			  "code" : 2000000,
      			  "msg" : "OK",
      			  "data" : [ {
      			    "id" : 14,
      			    "parentId" : -1,
      			    "children" : [ ],
      			    "icon" : "fa fa-database fa-fw",
      			    "title" : "数据池",
      			    "href" : "data_pool",
      			    "spread" : false,
      			    "code" : "dataPool",
      			    "enabled" : "1",
      			    "description" : null
      			  }, {
      			    "id" : 15,
      			    "parentId" : -1,
      			    "children" : [ ],
      			    "icon" : "fa fa-line-chart fa-fw",
      			    "title" : "仪表盘",
      			    "href" : "project",
      			    "spread" : false,
      			    "code" : "project",
      			    "enabled" : "1",
      			    "description" : null
      			  } ]
      			};
  	        	target.menus = res.data;
        		get('../menu/listUserAuthoritySystem',{},res=>{
	        		console.log(res);
	        	},error=>{
	        		
	        	});
	        }			
			
		}
    }

});



