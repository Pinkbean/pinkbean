/*! IE-Checker v1.0.0 | (c) 2007-2015 The GrotesQ | https://github.com/Unk/IE-Checker */
!function(){var e=navigator.userAgent.toLowerCase();if(-1!=e.indexOf("msie")||-1!=e.indexOf("trident")){var a=11;e=/msie ([0-9]{1,}[\.0-9]{0,})/.exec(e),e&&(a=parseInt(e[1]));var i="";i+=" is-ie",i+=" ie"+a;for(var t=a+1;11>=t;t++)i+=" lt-ie"+t;document.getElementsByTagName("html")[0].className+=i}}();

/**
 * ui Script
 * --------------------------------
 */

// owl-carousel 대응 (jquery 3.0에서 Deprecated된 이벤트 추가)
// jQuery.fn.andSelf= $.fn.addBack;
jQuery.fn.load = $.fn.ready;


(function(exports, $){
	var exports = exports;

	$(document).ready(function() {
		// 포커스
		skipNaviFocus();

		//사이드바
		sidebar();

		//탭 컨텐츠
		tab_contents();

		//파일업로드
		file_input();

		//tree메뉴
		tree_menu();

		//전체체크
		all_check();

		//datepicker
		datepicker();
	});

	function skipNaviFocus() {
		var $skipnav = $('#skipNavi a');
		$.each($skipnav, function(i) {
			var $a = $skipnav.eq(i);
			$($a.attr('href')).attr('tabindex',0).css('outline','none');
		})
	}

	function sidebar(){
		var $menu01 = $('.side-menu .menu01 > a');
		var $menu02 = $('.menu02-wrap > li > a');

		$.each($menu01, function(i) {
			var tg = $menu01.eq(i);

			if( !tg.next().hasClass('menu02-wrap')){
				tg.find('i.right').hide();
			}
			tg.on('click', function(e) {
				e.preventDefault();
				if( !tg.next().hasClass('menu02-wrap')){
					location.href = tg.attr('href');
				}
				if( tg.next().css("display") == "none"){
					open(tg);
				} else {
					close(tg);
				}
			})
		})

		$.each($menu02, function(i){
			var tg = $menu02.eq(i);
			tg.on("click",function(e){
				e.preventDefault();
				var tg = $(this);
				if( !tg.next().hasClass('menu03-wrap')){
					location.href = tg.attr('href');
				} else {
					// 메뉴 컨트롤
					if (tg.next().css("display") == "none") {
						open(tg);
					} else {
						close(tg);
					}
				}
			});
		});

		function open(tg){
			tg.addClass('active').next().slideDown(250)
			.parent().siblings().children('a').removeClass('active').next().slideUp(250);
		}

		function close(tg){
			tg.removeClass('active').next().slideUp(250);
		}
	}

	function tab_contents(){
		var $tab = $('.tab');
		var $tab_list = $tab.find('li');
		var $tab_content = $('.tab-contents > div');
		var percent = 100;
		var $large = $('.tab.large');

		//탭 리스트 개수에 따른 width 지정
		if($tab.hasClass('large')){
			$.each($large,function(i){
				var length = $large.eq(i).find('li').length;

				$large.eq(i).find('li').css("width",percent/length+"%");
			});
		}

		$tab_content.hide().eq(0).show();

		$tab_list.on("click",function(){
			var $tg = $(this);
			var idx = $tg.index();
			$tg.addClass('on').siblings().removeClass('on')
			.parent().next().find('>div').hide().eq(idx).fadeIn(200);
		});

	}

	function file_input(){
		$(document).on("change","input[type='file']",function(){
			var $tg = $(this);
			var $name = $tg.val().split('\\').pop();

			$tg.parent().next().find('input').val($name);
		});
	}

	function loaderIn() {
		var $loader = $('.loader-wrap');
		if ($loader.length) $loader.fadeIn(200);
	}
	function loaderOut() {
		var $loader = $('.loader-wrap');
		if ($loader.length) $loader.fadeOut(200);
	}

	function tree_menu(){
		$(".tree-menu").treemenu({
			delay:150,
		});
	}

	function all_check(){
		var allcheck_wrap = $('.allcheck-wrap');

		$.each(allcheck_wrap,function(){
			var tg = $(this);
			var check_list = tg.find('.list-check');
			var allcheck = tg.find('.allcheck');
			var list_length = check_list.length;

			allcheck.change(function(){
				if(allcheck.prop("checked")){
					check_list.prop("checked",true);
				} else {
					check_list.prop("checked",false);
				}
			});

			$(document).on('change',check_list,function(){
				if( tg.find('.list-check:checked').length == list_length){
					allcheck.prop('checked',true);
				} else {
					allcheck.prop('checked',false);
				}
			});
		});
	}

	function datepicker(){
		$('.start-date-picker input').datepicker({
			format: 'yyyy.mm.dd',
			autoHide: true,
			yearFirst: true,
			yearSuffix: '년',
			monthsShort: ['01','02','03','04','05','06','07','08','09','10','11','12'],
			daysMin: ['일','월','화','수','목','금','토'],
		});

		$('.end-date-picker input').datepicker({
			format: 'yyyy.mm.dd',
			autoHide: true,
			yearFirst: true,
			yearSuffix: '년',
			monthsShort: ['01','02','03','04','05','06','07','08','09','10','11','12'],
			daysMin: ['일','월','화','수','목','금','토'],
		});
	}

	exports.loaderIn = loaderIn;
	exports.loaderOut = loaderOut;

})(this, this.jQuery)


