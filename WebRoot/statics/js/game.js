/*
* @Author: victor.li
* @Date:   2017-12-13 16:09:41
* @Last Modified by:   victor.li
* @Last Modified time: 2017-12-14 17:15:43
*/
(function(){
	var ctx =null;
	var Game = {
		canvas : document.getElementById('canvas'),
		setup : function() {
			if(this.canvas.getContext){
				ctx = this.canvas.getContext('2d');
				this.width = this.canvas.width;
				this.height = this.canvas.height;
				Screen.welcome();
				this.canvas.addEventListener('click',this.runGame,false);
				Ctrl.init();
			}
		},
		runGame:function(){
			Game.canvas.removeEventListener('click',Game.runGame, false);
			Game.init();
			Game.animate();
		},
		animate:function(){
			Game.play = requestAnimFrame(Game.animate);
			Game.draw();
		},
		init:function(){
			Background.init();
			Hud.init();
			Ball.init();
			Paddle.init();
			Bricks.init();

		},
		draw:function(){
			ctx.clearRect(0,0,this.width,this.height);
			Background.draw();
			Hud.draw();
			Ball.draw();
			Bricks.draw();
			Paddle.draw();
		},
		levelUp:function(){
			Hud.lv += 1;
			Bricks.init();
			Ball.init();
			Paddle.init();
		},
		levelLimit:function(lv){
			return lv > 10 ? 10:lv;
		},
		restartGame:function(){
			Game.canvas.removeEventListener('click',Game.restartGame,false);
			Game.init();
		}
	};
	// 绘制背景图
	var Background = {
		init:function(){
			this.ready = false;
			this.img = new Image();
			this.img.src = 'images/smallgame/background.jpg';
			this.img.onload = function(){
				Background.ready = true;
			}
		},
		draw:function(){
			if(this.ready){
				ctx.drawImage(this.img,0,0);
			}
		}
	};
	// 绘制砖块
	var Bricks = {
		gap:2,
		col:5,
		w:80,
		h:15,
		init:function(){
			this.row = 2 + Game.levelLimit(Hud.lv);
			this.total = 0;
			this.count = [this.row];
			for(var i = this.row;i--;){
				this.count[i] = [this.col];
			}
		},
		draw:function(){
			var i,j;
			for(i=this.row;i--;){
				for(j=this.col;j--;){
					//如果为false 则不需要绘制砖块
					if(this.count[i][j] !== false){
						//检测小球是否和砖块重叠
						if(Ball.x >= this.x(j) && Ball.x <= (this.x(j)+this.w) && Ball.y >= this.y(i) && Ball.y <= (this.y(i) + this.h)){
							this.collide(i,j);
							continue;
						}
						ctx.fillStyle = this.gradient(i);
						ctx.fillRect(this.x(j), this.y(i), this.w, this.h);
					}
				}
			}
			//如果全部消除就升级
			if(this.total === (this.row * this.col)){
				Game.levelUp();
			}
		},
		//如果小球和砖块发生碰撞 分数增加
		collide:function(i,j){
			Hud.score += 1;
			this.total += 1;

			this.count[i][j] = false;
			Ball.sy = -Ball.sy;
		},
		x:function(row){
			return (row*this.w)+(row*this.gap);
		},
		y:function(col){
			return (col*this.h)+(col*this.gap);
		},
		//获取绘制砖块的颜色
		gradient:function(row){
			switch(row){
				case 0:
					return this.gradientPurple ? this.gradientPurple : this.gradientPurple = this.makeGradient(row,'#bd06f9','#9604c7');
				case 1:
					return this.gradientRed ? this.gradientRed : this.gradientRed = this.makeGradient(row,'#F9064A','#c7043b');
				case 2:
					return this.gradientGreen?this.gradientGreen :this.gradientGreen = this.makeGradient(row,'#05fa15','#04c711');
				default :
					return this.gradientOrange ? this.gradientOrange : this.gradientOrange = this.makeGradient(row,'#faa105','#c77f04');
			}

		},
		makeGradient:function(row,color1,color2){
			var y  = this.y(row);
			var grad = ctx.createLinearGradient(0,y,0,y+this.h);
			grad.addColorStop(0, color1);
			grad.addColorStop(1, color2);
			return grad;
		}
	};
	// 绘制球体
	var Ball = {
		r:10,
		init:function(){
			this.x=120;
			this.y=120;
			this.sx=1+(0.4*Hud.lv);
			this.sy=-1.5 -(0.4*Hud.lv);
		},
		draw:function(){
			this.edges();
			this.collide();
			this.move();
			ctx.beginPath();
			ctx.arc(this.x,this.y,this.r,0,2*Math.PI);
			ctx.closePath();
			ctx.fillStyle="#eee";
			ctx.fill();
		},
		//碰撞检测
		edges:function(){
			if(this.y < 1){
				this.y = 1;
				this.sy = -this.sy;
			}else if(this.y > Game.height){
				this.sy = this.sx = 0;
				this.y = this.x = 1000;
				Screen.gameover();
				// console.log(1211);
				canvas.addEventListener('click',Game.restartGame,false);
				return;
			}
			if(this.x < 1){
				this.x = 1;
				this.sx = -this.sx;
			}else if(this.x > Game.width){
				this.x = Game.width - 1;
				this.sx= -this.sx;
			}
		},
		//碰撞球拍
		collide:function(){
			if(this.x >= Paddle.x && this.x <= (Paddle.x + Paddle.w) && this.y >= Paddle.y && this.y <= (Paddle.y + Paddle.h)){
				this.sx = 7 * ((this.x - (Paddle.x + Paddle.w / 2)) / Paddle.w);
				this.sy = -this.sy;
			}
		},
		move:function(){
			this.x += this.sx;
			this.y += this.sy;
		}
	};
	// 绘制球板
	var Paddle = {
		w:90,
		h:20,
		r:9,
		init:function(){
			this.x = 100;
			this.y = 210;
			this.speed = 4;
		},
		draw:function(){
			this.move();
			ctx.beginPath();
			ctx.moveTo(this.x,this.y);
			ctx.arcTo(this.x+this.w, this.y, this.x+this.w, this.y+this.r,this.r);
			ctx.lineTo(this.x+this.w,this.y+this.h-this.r);
			ctx.arcTo(this.x+this.w,this.y+this.h,this.x+this.w-this.r,this.y+this.h,this.r);
			ctx.lineTo(this.x+this.r,this.y+this.h);
			ctx.arcTo(this.x,this.y+this.h,this.x,this.y+this.h-this.r,this.r);
			ctx.lineTo(this.x,this.y+this.r);
			ctx.arcTo(this.x,this.y,this.x+this.r,this.y,this.r);
			ctx.closePath();
			ctx.fillStyle = this.gradient();
			ctx.fill();
		},
		move:function(){
			if(Ctrl.left && (this.x < Game.width - (this.w / 2))){
				this.x += this.speed;
			}else if(Ctrl.right && this.x > -this.w/2){
				this.x += -this.speed;
			}
			
		},
		gradient:function(){
			if(this.gradientCache){
				return this.gradientCache;
			}
			this.gradientCache = ctx.createLinearGradient(this.x,this.y, this.x, this.y+20);
			this.gradientCache.addColorStop(0,'#eee');
			this.gradientCache.addColorStop(1, '#999');
			return this.gradientCache;
		}
	};
	//绑定操作事件
	var Ctrl = {
		init:function(){
			window.addEventListener('keydown',this.keyDown,true);
			window.addEventListener('keyup',this.keyUp,true);
			window.addEventListener('mousemove',this.movePaddle,true);

		},
		keyDown:function(event){
 			switch(event.keyCode){
 				case 39:
 					Ctrl.left = true;
 					break;
 				case 37:
 					Ctrl.right = true;
 					break;
 				default:
 					break;
 			}
		},
		keyUp:function(event){
			switch(event.keyCode){
				case 39:
					Ctrl.left = false;
					break;
				case 37:
					Ctrl.right = false;
					break;
				default:
					break;
			}
		},
		movePaddle:function(event){
			var mouseX = event.pageX;
			var canvasX = Game.canvas.offsetLeft;
			var paddleMid = Paddle.w / 2;
			if(mouseX > canvasX && mouseX < canvasX + Game.width){
				var newX = mouseX -canvasX;
				newX -= paddleMid;
				Paddle.x = newX;
			}
		}
	}
	//等分机制
	var Hud = {
		init:function(){
			this.lv = 1;
			this.score = 0;
		},
		draw:function(){
			ctx.font = '12px helvetice,arial';
			ctx.fillStyle = 'white';
			ctx.textAlign = 'left';
			ctx.fillText('得分: '+this.score, 5,Game.height-5);
			ctx.textAlign = 'right';
			ctx.fillText('LV: '+this.lv,Game.width-5,Game.height-5);
		}
	}
	//游戏开始结束封面
	var Screen = {
		welcome : function(){
			this.text = '打 砖 块';
			this.textSub = '点 击 开 始';
			this.textColor = 'white';
			this.create();
		},
		gameover:function(){
			console.log(Game.width);
			// cancelAnimationFrame(Game.play);
			this.text = '游 戏 结 束';
			this.textSub = '点 击 重 新 开 始';
			this.textColor = 'red';
			this.create();
		},
		create:function(){
			ctx.fillStyle = 'black';
			ctx.fillRect(0,0,Game.width,Game.height);

			ctx.fillStyle = this.textColor;
			ctx.textAlign = 'center';
			ctx.font = '40px helvetica,arial';
			ctx.fillText(this.text,Game.width / 2,Game.height / 2);

			ctx.fillStyle = "#999";
			ctx.font = '20px helvetica,arial';
			ctx.fillText(this.textSub,Game.width / 2,Game.height/2+30);
		}
	}
	window.onload = function(){
		Game.setup();
	}
	//帧动画
	window.requestAnimFrame = (function(){
		return window.requestAnimationFrame ||
		window.webkitRequestAnimationFrame  ||
		window.mozRequestAnimationFrame     ||
		window.oRequestAnimationFrame       ||
		window.msRequestAnimationFrame      ||
		function(callback){
			window.setTimeout(callback, 1000/60);
		}
	}());
	
}());