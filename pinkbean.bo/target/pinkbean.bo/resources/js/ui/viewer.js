// owl-carousel 대응 (jquery 3.0에서 Deprecated된 이벤트 추가)
jQuery.fn.andSelf= $.fn.addBack;
jQuery.fn.load = $.fn.ready;


(function(exports, $){
	var exports = exports;
	var $it;

	$(document).ready(function() {
		// 원전자료뷰어 줌인, 줌아웃
		zoomInOut();

		// 원전자료뷰어
		viewerCarousel();

		// 원전자료뷰어 사이드 온오프
		sideOnOff();

		$it = $("#canvas").panzoom( {
			increment: 0.1,
			minScale: 0.4,
			maxScale: 3,
			$zoomIn: $(".zoom-control .plus-btn"),
			$zoomOut: $(".zoom-control .minus-btn"),
		});
		var $image = $it.find('img');
		// console.log($image[0].naturalWidth);
		canvasScape($it, $image);
		$image.on({
			'ready':function(e) {
				console.log('ready');
				canvasScape($it, $image);
			},
			'load':function(e) {
				console.log(e);
				canvasScape($it, $image);
			}
		})
	});

	var it = {
		change:function(url) {
			var $img = $it.find('img');
			console.log($img);
			$img.attr('src', url);
		},
		reset: function() {
			$it.panzoom("resetZoom");
			$it.panzoom("resetPan");
		}
	}


	function canvasScape(canvas, image) {
		var $canvas = canvas;
		var $img = image;
		var cw = $canvas[0].clientWidth;
		var ch = $canvas[0].clientHeight;
		var iw = $img[0].naturalWidth;
		var ih = $img[0].naturalHeight;
		var wr = iw / cw;
		var hr = ih / ch;
		if (wr > 1 && hr <= 1) {
			$img.addClass('landscape');
		} else if (wr <= 1 && hr > 1) {
			$img.addClass('portrait');
		} else {
			if (wr > hr) {
				$img.addClass('landscape');
			} else {
				$img.addClass('portrait');
			}
		}
	}


	function zoomInOut(){
		var $articles = $('.text-data-article');
		if (!$articles.length) return;

		$.each($articles, function(i) {
			var $article = $articles.eq(i);
			var $vwrap = $article.find('.v-wrap02');
			var $minus = $article.find('.minus-btn');
			var $plus = $article.find('.plus-btn');
			var fz = 15; //기준폰트사이즈
			var minfz = 11;
			var maxfz = 21;

			$minus.on({
				'click': function(e) {
					e.preventDefault();
					fz = (minfz > fz-2) ? minfz : fz-2;
					$vwrap.css('font-size', (fz) + 'px');
				}
			});
			$plus.on({
				'click': function(e) {
					e.preventDefault();
					fz = (maxfz < fz+2) ? maxfz : fz+2;
					$vwrap.css('font-size', (fz) + 'px');
				}
			});
		});
	}

	function viewerCarousel() {
		$('.viewer-owl').owlCarousel({
			items: 1,
			nav: true,
			navText: ["<img src='../../resources/img/icon/viewer-owl-left.png'>","<img src='../../resources/img/icon/viewer-owl-right.png'>"]
		});
	}

	function sideOnOff() {
		var $btn = $('.button-position > button');
		var $left = $('.left-viewer');
		var $right = $('.right-viewer');
		$btn.on({
			'click': function(e){
				if($right.hasClass('off')) {
					$left.show();
					$right.removeClass('off');
				} else {
					$left.hide();
					$right.addClass('off');
				}
			}
		})
	}

	exports.it = it;
})(this, this.jQuery)


