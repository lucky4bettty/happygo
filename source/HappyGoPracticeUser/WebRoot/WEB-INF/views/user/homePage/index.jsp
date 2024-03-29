<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/include.jsp" %>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;">
<meta name="format-detection" content="telephone=no" />
<title>HAPPY GO-首頁</title>

<link rel="shortcut icon" href="favicon.ico?id=1" type="image/vnd.microsoft.icon" />
<link rel="icon" href="favicon.ico?id=1" type="image/vnd.microsoft.icon" />
<!-- betty -->
<link rel="stylesheet" type="text/css" href="<c:out value="${resourcesPath}"/>user/css/common_new.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="<c:out value="${resourcesPath}"/>user/css/slick_new.css"
	media="all" />
<link rel="stylesheet" media="only screen and (min-width: 604px) and (max-width: 999px)"  href="<c:out value="${resourcesPath}"/>user/css/pad_new.css"
	media="all" />
<link rel="stylesheet" media="only screen and (max-width: 603px)" href="<c:out value="${resourcesPath}"/>user/css/m-index_new.css"
	media="all" />
<link rel="stylesheet" href="<c:out value="${resourcesPath}"/>user/css/pushy_new.css" media="all" />

<!-- 輪播效果-->
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/jquery.min.js"></script>

<!-- 選單 -->
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/menu.js"></script>

<!-- 時鐘-->
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/jquery.plugin.min.js"></script>
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/jquery.countdown.js"></script>

<!-- 小網選單 -->
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/pushy.min.js"></script>

</head>
<body>
<!-- Pushy Menu -->
<nav class="pushy pushy-left">
  <div class="findarea p-block">
    <div class="findbox type3">
      <ul>
        <li class="findtext">
          <input type="text" value="" placeholder="請輸入關鍵字">
        </li>
        <li class="findselect">
          <select name="select" id="select">
            <option>特約商店</option>
            <option>熱門活動</option>
          </select>
        </li>
        <li class="findpush">
          <input type="button" value="" class="btn">
        </li>
      </ul>
    </div>
  </div>
  <div class="clr"></div>
  <ul>
    <li><a href="#"><img src="images/phone/icon_1.png">我的專區</a>
      <div class="submenu">
        <ul>
          <li><a href="#">現有點數</a>
            <p><span>333</span> 點</p>
          </li>
          <li><a href="#">建議兌換商品</a>
            <p><a href="#"><span>ibon中杯熱拿鐵ibon中杯熱拿鐵</span></a></p>
          </li>
          <li><a href="#">收藏則數</a>
            <p><a href="#"><span>6</span> 則</a></p>
          </li>
        </ul>
      </div>
    </li>
    <li><a href="#"><img src="images/phone/icon_2.png">回首頁</a></li>
    <li class="main active"><a href="#">卡友好康</a>
      <div class="submenu">
        <ul>
          <li><a href="#">卡友好康首頁</a></li>
          <li><a href="#">集點活動</a></li>
          <li><a href="#">兌點活動</a></li>
          <li><a href="#">持卡優惠</a></li>
          <li><a href="#">免費得點</a></li>
          <li><a href="#">主題活動</a></li>
          <li><a href="#">活動公告</a></li>
        </ul>
      </div>
    </li>
    <li class="main"><a href="#">卡友中心1</a></li>
    <li class="main"><a href="#">主題活動2</a></li>
    <li class="main"><a href="#">愛心捐點3</a></li>
    <li class="main"><a href="#">快樂購特約商4</a></li>
    <li class="main"><a href="#">快樂購卡介紹5</a></li>
    <li class="main"><a href="#">客服園地6</a></li>
    <li class="main active"><a href="#">相關連結</a>
      <div class="submenu">
        <ul>
          <li><a href="#">關於HAPPY GO</a></li>
          <li><a href="#">快樂購卡友權益需知</a></li>
          <li><a href="#">智慧財產權保護聲明</a></li>
          <li class="active"><a href="#">隱私權政策</a></li>
          <li><a href="#">快樂購卡特約商服務</a></li>
          <li><a href="#">網站友好夥伴</a></li>
        </ul>
      </div>
    </li>
    <li><a href="#">加入粉絲團</a></li>
    <li><a href="#">快去下載APP</a></li>
    <li><a href="#">線上申辦</a></li>
  </ul>
</nav>

<!-- Site Overlay -->
<div class="site-overlay"></div>
<!-- 手機版測邊選單 -->
<div class="m-header">
  <div class="menu-btn"></div>
  <div class="logo"></div>
  <!--<div class="login-btn"></div>-->
  <div class="logout-btn"></div>
</div>
<div class="top">
  <div class="topnav">
    <ul>
	    <c:forEach items="${mainMenuList}" var="data">
			<li><a href="#">${data.name}</a></li>
		</c:forEach>
    </ul>
    <div class="top_fb"><img src="images/fb-like.png"></div>
    <div class="top_fbAdd"><a href="#">加入粉絲團</a></div>
    <div class="top_appDl"><a href="#">快去下載APP！</a></div>
  </div>
</div>
<div class="header">
  <div class="com">
    <div class="logo"><a href="#"><img src="<c:out value="${resourcesPath}"/>user/images/logo.png" alt="HAPPY GO"></a></div>
    <div class="searchArea"><span class="keywords">熱門： <a href="#">跨年集點趣</a>、<a href="#">點數變現金</a></span>
      <div class="search">
        <input class="query-input" id="nav-search-input" placeholder="請輸入查詢關鍵字" />
        <select>
          <option>特約商店</option>
          <option>熱門活動</option>
        </select>
        <div class="search_btn"><a href="#"></a></div>
      </div>
    </div>
    <div class="clock">
      <div class="clocktit">點數優惠兌換倒數</div>
      <div id="clock">154787</div>
    </div>
  </div>
  <div id="abgne-block">
    <div class="inner">
<!--       <ul class="tabs"> -->
<!--         <li class="m1"> -->
<!--           <div class="hot"></div> -->
<!--           <a href="#">卡友好康1</a></li> -->
<!--         <li class="m2"> -->
<!--           <div class="new"></div> -->
<!--           <a href="#">卡友專區2</a></li> -->
<!--         <li class="m3"><a href="#">愛心捐點3</a></li> -->
<!--         <li class="m4"><a href="#">達人分享4</a></li> -->
<!--         <li class="m5"><a href="#">快樂購特約商5</a></li> -->
<!--         <li class="m6"><a href="#">快樂購卡介紹6</a></li> -->
<!--         <li class="m7"><a href="#">連絡我們</a></li> -->
<!--       </ul> -->
	 <ul class="tabs">
	 	<c:forEach items="${mainMenuList}" var="data">
			<li class="m${data.sort}"><a href="#">${data.name}</a></li>
		</c:forEach>
	 </ul>
      <div class="tab_container">
        <ul class="tab_content">
        	<c:forEach items="${mainMenuList}" var="data">
				<li class="m${data.sort}">
		            <div class="subnavbox">
		              <div class="mainL">
		                <div class="fL"><img src="img/subnav.png"></div>
		                <h2>${data.name}</h2>
		                <p>專屬優惠享不停，小額付款最快速。
		                  快升級HappyCash卡，點點換現金，七大百貨讓你換不停！</p>
		                <input type="button" value="更多詳情">
		              </div>
		              <div class="menuR">
		                <h3>如何使用快樂購卡</h3>
		                <c:forEach items="${subMenuList}" var="dataSub">
		                	<c:if test="${data.id eq dataSub.main_menu}">
		                		<div><a href="#">${dataSub.name}</a></div>
		                	</c:if>
		                </c:forEach>
		              </div>
		            </div>
	          	</li>
			</c:forEach>
<!--           <li class="m01"> -->
<!--             <div class="subnavbox"> -->
<!--               <div class="mainL"> -->
<!--                 <div class="fL"><img src="img/subnav.png"></div> -->
<!--                 <h2>111享生活。玩體驗</h2> -->
<!--                 <p>輕鬆集點，快樂分享！最多好康，<br> -->
<!--                   最多優惠，全部都在HAPPY GO卡！</p> -->
<!--                 <input type="button" value="更多詳情"> -->
<!--               </div> -->
<!--               <div class="menuR">  -->
<!--                 <h3><a href="#">如何使用快樂購卡</a></h3> -->
<!--                 <div><a href="#">點數及交易明細查詢</a></div> -->
<!--                 <div><a href="#">點數及交易明細查詢</a></div> -->
<!--                 <div><a href="#">主題活動QQ</a></div> -->
<!--                 <div><a href="#">活動公告</a></div> -->
<!--                 <div><a href="#">兌點活動</a></div> -->
<!--                 <div><a href="#">免費得點</a></div> -->
<!--                 <div><a href="#">線上兌換</a></div> -->
<!--                 <div class="addsub"><a href="#">小點數大驚喜</a> -->
<!--                   <div><a href="#">戳戳樂</a></div> -->
<!--                   <div><a href="#">彈珠台</a></div> -->
<!--                 </div> -->
<!--               </div> -->
<!--             </div> -->
<!--           </li> -->
<!--           <li class="m02"> -->
<!--             <div class="subnavbox"> -->
<!--               <div class="mainL"> -->
<!--                 <div class="fL"><img src="img/subnav.png"></div> -->
<!--                 <h2>222嗶你有錢！HappyCash</h2> -->
<!--                 <p>專屬優惠享不停，小額付款最快速。 -->
<!--                   快升級HappyCash卡，點點換現金，七大百貨讓你換不停！</p> -->
<!--                 <input type="button" value="更多詳情"> -->
<!--               </div> -->
<!--               <div class="menuR"> -->
<!--                 <h3>如何使用快樂購卡</h3> -->
<!--                 <div><a href="#">新手上路懶人包</a></div> -->
<!--                 <div><a href="#">基本功能介紹</a></div> -->
<!--                 <div><a href="#">基本累兌點原則</a></div> -->
<!--                 <div><a href="#">線上兌換</a></div> -->
<!--                 <div><a href="#">愛心捐點</a></div> -->
<!--                 <div><a href="#">電子發票</a></div> -->
<!--                 <div><a href="#">達人秘笈</a></div> -->
<!--               </div> -->
<!--             </div> -->
<!--           </li> -->

        </ul>
      </div>
    </div>
  </div>
</div>
<div id="slickbox">
  <div class="inner">
    <div class="topbox">
      <div class="variable-width">
        <ul>
          <li>
            <div class="video-container">
              <iframe width="720" height="400" src="https://www.youtube.com/embed/LokvcieQpjw?rel=0" frameborder="0" allowfullscreen></iframe>
            </div>
          </li>
          <li><img src="img/720x400.jpg" alt="" border="0"></li>
          <li><img src="img/720x400.jpg" alt="" border="0"></li>
          <li><img src="img/720x400.jpg" alt="" border="0"></li>
        </ul>
      </div>
    </div>
    <div class="loginbox">
      <div class="main">
        <h3>XXX<span>您好：</span></h3>
        <div class="member_info">
          <ul>
            <li>您現有點數<span>XXX</span>點</li>
            <li>您收藏的優惠將於<br>
              <span>3</span>天內到期</li>
          </ul>
        </div>
        <div class="member_gift">
          <ul>
            <li>
              <div class="pic"><img src="img/p11.png" alt="" border="0"></div>
              <p>建議兌換商品<br>
                7-11 <span>20元現金抵用券</span></p>
            </li>
            <li>
              <div class="pic"><img src="img/p11.png" alt="" border="0"></div>
              <p>建議兌換商品<br>
                7-11 <span>20元現金抵用券</span></p>
            </li>
            <li>
              <div class="pic"><img src="img/p11.png" alt="" border="0"></div>
              <p>建議兌換商品<br>
                7-11 <span>20元現金抵用券</span></p>
            </li>
          </ul>
        </div>
      </div>
      <div class="main" style="display: none;">
        <h2>HAPPYGO卡友</h2>
        <div class="login_bt"><a href="#">手機門號<br>
          登入</a></div>
        <ul>
          <li><a href="#">手機門號首次登入</a></li>
          <li><a href="#">忘記登記門號</a></li>
          <li><a href="#">忘記密碼</a></li>
        </ul>
        <!--<div class="member_gift2">
              <div class="pic"><img src="img/p11.png" alt="" border="0"></div>
              <p>建議兌換商品<br>
                7-11 <span>20元現金抵用券</span></p>
        </div>--> 
      </div>
      <ul class="login_other">
        <li class="l1"><a href="#">點數查詢</a></li>
        <li class="l2"><a href="#">資料更新</a></li>
        <li class="l3"><a href="#">收藏優惠</a></li>
      </ul>
    </div>
  </div>
</div>
<div id="inContainer">
  <div class="boxarea">
    <div class="marquee m-none">六月份景氣消費觀測，只要花少許時間填寫我們的問卷，提供您寶貴的意見六月份景氣消費觀測，只要花少許時間填寫我們的問卷，提供您寶貴的意見...</div>
    <div class="box">
      <div class="title">
        <h2><img src="images/icon_1n.png" />優惠推薦 </h2>
      </div>
      <div class="block">
        <div class="slider responsive">
          <ul class="product">
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">生活購物</a></h3>
              <div class="pic"><a href="#"><img src="img/p1.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">生活必備</a></h3>
              <div class="pic"><a href="#"><img src="img/p2.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">休閒娛樂</a></h3>
              <div class="pic"><a href="#"><img src="img/p3.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">文化3C</a></h3>
              <div class="pic"><a href="#"><img src="img/p4.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">生活購物</a></h3>
              <div class="pic"><a href="#"><img src="img/p1.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">生活必備</a></h3>
              <div class="pic"><a href="#"><img src="img/p2.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">休閒娛樂</a></h3>
              <div class="pic"><a href="#"><img src="img/p3.jpg" width="225" height="225" /></a></div>
            </li>
            <li class="imgSet">
              <h3 class="tt_g"><a href="#">文化3C</a></h3>
              <div class="pic"><a href="#"><img src="img/p4.jpg" width="225" height="225" /></a></div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="toparea">
    <div class="box_s cardSet">
      <ul class="grid" id="grid">
        <li class="box_b"><a href="#"><img src="img/big380.jpg"></a></li>
        <li><a href="#"><img src="img/s190_1.jpg" width="190" height="190" /></a></li>
        <li><a href="#"><img src="img/s190_2.jpg" width="190" height="190" /></a></li>
        <li><a href="#"><img src="img/s190_3.jpg" width="190" height="190" /></a></li>
      </ul>
      <div class="banner"><a href="#"><img src="img/600x170.jpg" width="600" height="170" /></a></div>
      <div class="clr"></div>
    </div>
    <!--<div class="box_s">
        <ul class="grid" id="grid">
          <li class="box_b"><a href="#"><img src="img/big300.jpg"></a></li>
          <li>
            <div class="pic"><a href="#"><img src="img/s180_1.jpg" width="180" height="180" /></a></div>
            <h3><a href="#">卡友權益</a></h3>
          </li>
          <li>
            <div class="pic"><a href="#"><img src="img/s180_2.jpg" width="180" height="180" /></a></div>
            <h3><a href="#">點數查詢</a></h3>
          </li>
          <li>
            <div class="pic"><a href="#"><img src="img/s180_3.jpg" width="180" height="180" /></a></div>
            <h3><a href="#">熱門活動</a></h3>
          </li>
        </ul>
        <div class="banner"><a href="#"><img src="img/banner.jpg" width="584" height="138" /></a></div>
        <div class="clr"></div>
      </div>--> 
  </div>
  <div class="boxarea">
    <div class="box">
      <div class="title">
        <h2><img src="images/icon_2n.png" />開心購物</h2>
      </div>
      <div class="block">
        <ul class="prodpic">
          <li>
            <div class="pic"><img src="img/h100_1.png" width="325" height="100"></div>
          </li>
          <li>
            <div class="pic"><img src="img/h100_2.png" width="325" height="100"></div>
          </li>
          <li>
            <div class="pic"><img src="img/h100_3.png" width="325" height="100"></div>
          </li>
        </ul>
        <div class="clr"></div>
      </div>
    </div>
  </div>
</div>
<div class="ads"><a href="#"><img src="img/ads_300x250.jpg"></a></div>
<div class="footer">
  <div class="wm-auto">
    <div class="f-linkbox m-none">
      <ul>
        <li class="l1"><a href="#">答客問</a></li>
        <li class="l2"><a href="#">客服信箱</a></li>
        <li class="l3"><a href="#">語音客服專線</a></li>
        <li class="l4"><a href="#">HAPPY GO線上通</a></li>
      </ul>
    </div>
  </div>
  <div class="f-subnav m-none">
    <ul>
	    <c:forEach items="${footerList}" var="data">
			<li><a href="#">${data.name}</a></li>
		</c:forEach>
<!--       <li><a href="#">快樂購卡友權益需知</a></li> -->
<!--       <li><a href="#">智慧財產權保護聲明</a></li> -->
<!--       <li><a href="#">快樂購卡特約商服務網站</a></li> -->
<!--       <li><a href="#">友好夥伴</a></li> -->
    </ul>
  </div>
  <div class="wm-auto">
    <div class="copybox clr">
      <p>本網站刊登之所有特約商促銷訊息，均以特約商門市公告為主，若有調整，恕不另行通知，歡迎卡友告知刊登調整！</p>
      <p class="copyright">鼎鼎聯合行銷(股)公司版權所有 Copyright 2017 All Right Reserved by DDIM</p>
      <div class="logo"><a href="#"></a></div>
    </div>
  </div>
  <!-- wm-auto --> 
</div>
<div class="m-none">
  <div id="adbox"><img src="images/ad.png" width="90" height="300"></div>
</div>
<!-- slick大圖輪播--> 
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/slick.min.js"></script>
<script type="text/javascript" src="<c:out value="${resourcesPath}"/>user/js/slick.min.user.js"></script>
<script>

// $('#abgne-block li').on('click',function() {
// 	console.log('betty test');
// // 	console.log(<c:out value="${subMenuList}"/>);
// 	if ($(this).hasClass( "m8" )) {
// 		$tab_content.slidUp();
// 		slideUpHeaderMenu();
// 	}else{
// 		$tab_content.slideDown();
// //				slideDownHeaderMenu(); //slick banner must be stop.( RD callback function)
// 	}
// });

</script>

<!-- 其它效果-->
</body>
</html>