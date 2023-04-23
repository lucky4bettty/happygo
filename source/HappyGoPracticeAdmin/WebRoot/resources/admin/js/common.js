function edit(id) {
	location = 'edit.do?id=' + id;
}

function add() {
	location = 'edit.do';
}

function selectAll() {
	var checked = document.getElementsByName("all")[0].checked;
	var sn = document.getElementsByName("ids");
	for ( var i = 0; i < sn.length; i++) {
		sn[i].checked = checked;
	}
}

function deleteMultiple() {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選刪除項目!");
		return false;
	} else {
		if (confirm("你確定要刪除選取資料?")) {
			document.forms['uForm'].action = 'delete.do';
			document.forms['uForm'].submit();
		}
	}
}

function deleteMultipleParent(child) {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選刪除項目!");
		return false;
	} else {
		if (confirm("你確定要刪除選取資料?此舉將會連帶刪除" + child + "管理的相關資料!")) {
			document.forms['uForm'].action = 'delete.do';
			document.forms['uForm'].submit();
		}
	}
}

function deleteIt() {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選刪除項目!");
		return false;
	} else {
		if (confirm("你確定要刪除選取資料?")) {
			document.forms['uForm'].action = 'delete.do';
			document.forms['uForm'].submit();
		}
	}
}

function update(status) {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選更新項目!");
		return false;
	} else {
		if (confirm("你確定要更新選取資料?")) {
			document.forms['uForm'].action = 'update.do?status=' + status;
			document.forms['uForm'].submit();
		}
	}
}

function update_homepage(homepage) {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選更新項目!");
		return false;
	} else {
		if (confirm("你確定要更新選取資料?")) {
			document.forms['uForm'].action = 'update_homepage.do?homepage=' + homepage;
			document.forms['uForm'].submit();
		}
	}
}

function update_leftmenu(leftmenu) {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選更新項目!");
		return false;
	} else {
		if (confirm("你確定要更新選取資料?")) {
			document.forms['uForm'].action = 'update_leftmenu.do?leftmenu=' + leftmenu;
			document.forms['uForm'].submit();
		}
	}
}

function updateSort(id, sort, sortTemp) {
	if (confirm("你要更新選取資料?")) {
		location.href = 'updateSort.do?id=' + id + '&sort=' + sort + '&sortTemp=' + sortTemp;
	}
}

function drawImage(ImgD, FitWidth, FitHeight) {
	var image = new Image();
	image.src = ImgD.src;
	if (image.width > 0 && image.height > 0) {
		if (image.width / image.height >= FitWidth / FitHeight) {
			if (image.width > FitWidth) {
				ImgD.width = FitWidth;
				ImgD.height = (image.height * FitWidth) / image.width;
			} else {
				ImgD.width = image.width;
				ImgD.height = image.height;
			}
		} else {
			if (image.height > FitHeight) {
				ImgD.height = FitHeight;
				ImgD.width = (image.width * FitHeight) / image.height;
			} else {
				ImgD.width = image.width;
				ImgD.height = image.height;
			}
		}
	}
	try {
		ImgD.style.display = "";
	} catch (e) {
	}
}

function getFileName(url) {
	var strobj = url;
	if (strobj == '') {
		return "";
	} else {
		var file_value = strobj.toUpperCase();
		var index = file_value.lastIndexOf('/', file_value.length);
		var file_attribute = file_value.substr(index + 1);
		return file_attribute;
	}
}

function hasChecked(name) {
	var chkObj = document.getElementsByName(name);
	if (chkObj[0]) {
		for ( var i = 0; i < chkObj.length; ++i) {
			if (chkObj[i].checked) {
				return true;
			}
		}
	} else if (chkObj) {
		return chkObj.checked;
	}
	return false;
}

function oneAffectsOthers(itself, others, behavior) {
	if ($("#" + itself+"").prop("checked")) {
		if (behavior == "show"|| behavior == 1) {
			if (Array.isArray(others)) {
				others.forEach(function(item, index, array){
					$("#" + item + "Icon").show();
					document.getElementById(item + ".errors").style.display = "inline-block";
				});
			} else {
				$("#" + others + "Icon").show();
				document.getElementById(others + ".errors").style.display = "inline-block";
			}
		} else {
			if (Array.isArray(others)) {
				others.forEach(function(item, index, array){
					$("#" + item + "Icon").hide();
					document.getElementById(item + ".errors").style.display = "none";
				});
			} else {
				$("#" + others + "Icon").hide();
				document.getElementById(others + ".errors").style.display = "none";
			}
		}
	} else {
		if (behavior == "show"|| behavior == 1) {
			if (Array.isArray(others)) {
				others.forEach(function(item, index, array){
					$("#" + item + "Icon").hide();
					document.getElementById(item + ".errors").style.display = "none";
				});
			} else {
				$("#" + others + "Icon").hide();
				document.getElementById(others + ".errors").style.display = "none";
			}
		} else {
			if (Array.isArray(others)) {
				others.forEach(function(item, index, array){
					$("#" + item + "Icon").show();
					document.getElementById(item + ".errors").style.display = "inline-block";
				});
			} else {
				$("#" + others + "Icon").show();
				document.getElementById(others + ".errors").style.display = "inline-block";
			}
		}
	}
}

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function isAscii(pattern) {
	for ( var i = 0; i < pattern.length; i++) {
		if (pattern.charCodeAt(i) > 127) {
			return false;
		}
	}
	return true;
}
function getCookie(name) {
	var start = document.cookie.indexOf(name + "=");
	var len = start + name.length + 1;
	if ((!start) && (name != document.cookie.substring(0, name.length))) {
		return null;
	}
	if (start == -1)
		return null;
	var end = document.cookie.indexOf(";", len);
	if (end == -1)
		end = document.cookie.length;
	return unescape(document.cookie.substring(len, end));
}

function submitForm(url) {
	$("#sForm").attr("action", url);
	$("#sForm").submit();
}

function exportExcel() {
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選更新項目!");
		return false;
	} else {
		if (confirm("你確定要匯出選取資料?")) {
			document.forms['uForm'].action = 'exportExcel.do?' ;
			document.forms['uForm'].submit();
		}
	}
}

function cityChange(city) {
	switch (city) {
	case"基隆市":
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("200").text("仁愛區"));
		$("#cityArea").append($("<option></option>").val("201").text("信義區"));
		$("#cityArea").append($("<option></option>").val("202").text("中正區"));
		$("#cityArea").append($("<option></option>").val("203").text("中山區"));
		$("#cityArea").append($("<option></option>").val("204").text("安樂區"));
		$("#cityArea").append($("<option></option>").val("205").text("暖暖區"));
		$("#cityArea").append($("<option></option>").val("206").text("七堵區"));
		$("#postal_code").val($("#cityArea").val());
		break;
	case"臺北市":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("100").text("中正區"));		
		$("#cityArea").append($("<option></option>").val("103").text("大同區"));		
		$("#cityArea").append($("<option></option>").val("104").text("中山區"));		
		$("#cityArea").append($("<option></option>").val("105").text("松山區"));		
		$("#cityArea").append($("<option></option>").val("106").text("大安區"));		
		$("#cityArea").append($("<option></option>").val("108").text("萬華區"));		
		$("#cityArea").append($("<option></option>").val("110").text("信義區"));		
		$("#cityArea").append($("<option></option>").val("111").text("士林區"));		
		$("#cityArea").append($("<option></option>").val("112").text("北投區"));		
		$("#cityArea").append($("<option></option>").val("114").text("內湖區"));		
		$("#cityArea").append($("<option></option>").val("115").text("南港區"));		
		$("#cityArea").append($("<option></option>").val("116").text("文山區"));
		$("#postal_code").val($("#cityArea").val());
		break;
	case"新北市":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("207").text("萬里區"));		
		$("#cityArea").append($("<option></option>").val("208").text("金山區"));		
		$("#cityArea").append($("<option></option>").val("220").text("板橋區"));		
		$("#cityArea").append($("<option></option>").val("221").text("汐止區"));		
		$("#cityArea").append($("<option></option>").val("222").text("深坑區"));		
		$("#cityArea").append($("<option></option>").val("223").text("石碇區"));		
		$("#cityArea").append($("<option></option>").val("224").text("瑞芳區"));		
		$("#cityArea").append($("<option></option>").val("226").text("平溪區"));		
		$("#cityArea").append($("<option></option>").val("227").text("雙溪區"));		
		$("#cityArea").append($("<option></option>").val("228").text("貢寮區"));		
		$("#cityArea").append($("<option></option>").val("231").text("新店區"));		
		$("#cityArea").append($("<option></option>").val("232").text("坪林區"));		
		$("#cityArea").append($("<option></option>").val("233").text("烏來區"));		
		$("#cityArea").append($("<option></option>").val("234").text("永和區"));		
		$("#cityArea").append($("<option></option>").val("235").text("中和區"));		
		$("#cityArea").append($("<option></option>").val("236").text("土城區"));		
		$("#cityArea").append($("<option></option>").val("237").text("三峽區"));		
		$("#cityArea").append($("<option></option>").val("238").text("樹林區"));		
		$("#cityArea").append($("<option></option>").val("239").text("鶯歌區"));		
		$("#cityArea").append($("<option></option>").val("241").text("三重區"));		
		$("#cityArea").append($("<option></option>").val("242").text("新莊區"));		
		$("#cityArea").append($("<option></option>").val("243").text("泰山區"));		
		$("#cityArea").append($("<option></option>").val("244").text("林口區"));		
		$("#cityArea").append($("<option></option>").val("247").text("蘆洲區"));		
		$("#cityArea").append($("<option></option>").val("248").text("五股區"));		
		$("#cityArea").append($("<option></option>").val("249").text("八里區"));		
		$("#cityArea").append($("<option></option>").val("251").text("淡水區"));		
		$("#cityArea").append($("<option></option>").val("252").text("三芝區"));		
		$("#cityArea").append($("<option></option>").val("253").text("石門區"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"桃園市":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("320").text("中壢區"));		
		$("#cityArea").append($("<option></option>").val("324").text("平鎮區"));		
		$("#cityArea").append($("<option></option>").val("325").text("龍潭區"));		
		$("#cityArea").append($("<option></option>").val("326").text("楊梅區"));		
		$("#cityArea").append($("<option></option>").val("327").text("新屋區"));		
		$("#cityArea").append($("<option></option>").val("328").text("觀音區"));		
		$("#cityArea").append($("<option></option>").val("330").text("桃園區"));		
		$("#cityArea").append($("<option></option>").val("333").text("龜山區"));		
		$("#cityArea").append($("<option></option>").val("334").text("八德區"));		
		$("#cityArea").append($("<option></option>").val("335").text("大溪區"));		
		$("#cityArea").append($("<option></option>").val("336").text("復興區"));		
		$("#cityArea").append($("<option></option>").val("337").text("大園區"));		
		$("#cityArea").append($("<option></option>").val("338").text("蘆竹區"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"新竹市":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("300").text("新竹市"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"新竹縣":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("302").text("竹北"));		
		$("#cityArea").append($("<option></option>").val("303").text("湖口"));		
		$("#cityArea").append($("<option></option>").val("304").text("新豐"));		
		$("#cityArea").append($("<option></option>").val("305").text("新埔"));		
		$("#cityArea").append($("<option></option>").val("306").text("關西"));		
		$("#cityArea").append($("<option></option>").val("307").text("芎林"));		
		$("#cityArea").append($("<option></option>").val("308").text("寶山"));		
		$("#cityArea").append($("<option></option>").val("310").text("竹東"));		
		$("#cityArea").append($("<option></option>").val("311").text("五峰"));		
		$("#cityArea").append($("<option></option>").val("312").text("橫山"));		
		$("#cityArea").append($("<option></option>").val("313").text("尖石"));		
		$("#cityArea").append($("<option></option>").val("314").text("北埔"));		
		$("#cityArea").append($("<option></option>").val("315").text("峨眉"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"苗栗縣":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("350").text("竹南"));		
		$("#cityArea").append($("<option></option>").val("351").text("頭份"));		
		$("#cityArea").append($("<option></option>").val("352").text("三灣"));		
		$("#cityArea").append($("<option></option>").val("353").text("南庄"));		
		$("#cityArea").append($("<option></option>").val("354").text("獅潭"));		
		$("#cityArea").append($("<option></option>").val("356").text("後龍"));		
		$("#cityArea").append($("<option></option>").val("357").text("通霄"));		
		$("#cityArea").append($("<option></option>").val("358").text("苑裡"));		
		$("#cityArea").append($("<option></option>").val("360").text("苗栗"));		
		$("#cityArea").append($("<option></option>").val("361").text("造橋"));		
		$("#cityArea").append($("<option></option>").val("362").text("頭屋"));		
		$("#cityArea").append($("<option></option>").val("363").text("公館"));		
		$("#cityArea").append($("<option></option>").val("364").text("大湖"));		
		$("#cityArea").append($("<option></option>").val("365").text("泰安"));		
		$("#cityArea").append($("<option></option>").val("366").text("銅鑼"));		
		$("#cityArea").append($("<option></option>").val("367").text("三義"));		
		$("#cityArea").append($("<option></option>").val("368").text("西湖"));		
		$("#cityArea").append($("<option></option>").val("369").text("卓蘭"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"臺中市":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("400").text("中區"));		
		$("#cityArea").append($("<option></option>").val("401").text("東區"));		
		$("#cityArea").append($("<option></option>").val("402").text("南區"));		
		$("#cityArea").append($("<option></option>").val("403").text("西區"));		
		$("#cityArea").append($("<option></option>").val("404").text("北區"));		
		$("#cityArea").append($("<option></option>").val("406").text("北屯區"));		
		$("#cityArea").append($("<option></option>").val("407").text("西屯區"));		
		$("#cityArea").append($("<option></option>").val("408").text("南屯區"));		
		$("#cityArea").append($("<option></option>").val("411").text("太平區"));		
		$("#cityArea").append($("<option></option>").val("412").text("大里區"));		
		$("#cityArea").append($("<option></option>").val("413").text("霧峰區"));		
		$("#cityArea").append($("<option></option>").val("414").text("烏日區"));		
		$("#cityArea").append($("<option></option>").val("420").text("豐原區"));		
		$("#cityArea").append($("<option></option>").val("421").text("后里區"));		
		$("#cityArea").append($("<option></option>").val("422").text("石岡區"));		
		$("#cityArea").append($("<option></option>").val("423").text("東勢區"));		
		$("#cityArea").append($("<option></option>").val("424").text("和平區"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"彰化縣":	
		$("#cityArea").empty();
		$("#cityArea").append($("<option></option>").val("500").text("彰化"));		
		$("#cityArea").append($("<option></option>").val("502").text("芬園"));		
		$("#cityArea").append($("<option></option>").val("503").text("花壇"));		
		$("#cityArea").append($("<option></option>").val("504").text("秀水"));		
		$("#cityArea").append($("<option></option>").val("505").text("鹿港"));		
		$("#cityArea").append($("<option></option>").val("506").text("福興"));		
		$("#cityArea").append($("<option></option>").val("507").text("線西"));		
		$("#cityArea").append($("<option></option>").val("508").text("和美"));		
		$("#cityArea").append($("<option></option>").val("509").text("伸港"));		
		$("#cityArea").append($("<option></option>").val("510").text("員林"));		
		$("#cityArea").append($("<option></option>").val("511").text("社頭"));		
		$("#cityArea").append($("<option></option>").val("512").text("永靖"));		
		$("#cityArea").append($("<option></option>").val("513").text("埔心"));		
		$("#cityArea").append($("<option></option>").val("514").text("溪湖"));		
		$("#cityArea").append($("<option></option>").val("515").text("大村"));		
		$("#cityArea").append($("<option></option>").val("516").text("埔鹽"));		
		$("#cityArea").append($("<option></option>").val("520").text("田中"));		
		$("#cityArea").append($("<option></option>").val("521").text("北斗"));		
		$("#cityArea").append($("<option></option>").val("522").text("田尾"));		
		$("#cityArea").append($("<option></option>").val("523").text("埤頭"));		
		$("#cityArea").append($("<option></option>").val("524").text("溪州"));		
		$("#cityArea").append($("<option></option>").val("525").text("竹塘"));		
		$("#cityArea").append($("<option></option>").val("526").text("二林"));		
		$("#cityArea").append($("<option></option>").val("527").text("大城"));		
		$("#cityArea").append($("<option></option>").val("528").text("芳苑"));		
		$("#cityArea").append($("<option></option>").val("530").text("二水"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"南投縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("540").text("南投"));		
		$("#cityArea").append($("<option></option>").val("541").text("中寮"));		
		$("#cityArea").append($("<option></option>").val("542").text("草屯"));		
		$("#cityArea").append($("<option></option>").val("544").text("國姓"));		
		$("#cityArea").append($("<option></option>").val("545").text("埔里"));		
		$("#cityArea").append($("<option></option>").val("546").text("仁愛"));		
		$("#cityArea").append($("<option></option>").val("551").text("名間"));		
		$("#cityArea").append($("<option></option>").val("552").text("集集"));		
		$("#cityArea").append($("<option></option>").val("553").text("水里"));		
		$("#cityArea").append($("<option></option>").val("555").text("魚池"));		
		$("#cityArea").append($("<option></option>").val("556").text("信義"));		
		$("#cityArea").append($("<option></option>").val("557").text("竹山"));		
		$("#cityArea").append($("<option></option>").val("558").text("鹿谷"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"雲林縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("630").text("斗南"));		
		$("#cityArea").append($("<option></option>").val("631").text("大埤"));		
		$("#cityArea").append($("<option></option>").val("632").text("虎尾"));		
		$("#cityArea").append($("<option></option>").val("633").text("土庫"));		
		$("#cityArea").append($("<option></option>").val("634").text("褒忠"));		
		$("#cityArea").append($("<option></option>").val("635").text("東勢"));		
		$("#cityArea").append($("<option></option>").val("636").text("臺西"));		
		$("#cityArea").append($("<option></option>").val("637").text("崙背"));		
		$("#cityArea").append($("<option></option>").val("638").text("麥寮"));		
		$("#cityArea").append($("<option></option>").val("640").text("斗六"));		
		$("#cityArea").append($("<option></option>").val("643").text("林內"));		
		$("#cityArea").append($("<option></option>").val("646").text("古坑"));		
		$("#cityArea").append($("<option></option>").val("647").text("莿桐"));		
		$("#cityArea").append($("<option></option>").val("648").text("西螺"));		
		$("#cityArea").append($("<option></option>").val("649").text("二崙"));		
		$("#cityArea").append($("<option></option>").val("651").text("北港"));		
		$("#cityArea").append($("<option></option>").val("652").text("水林"));		
		$("#cityArea").append($("<option></option>").val("653").text("口湖"));		
		$("#cityArea").append($("<option></option>").val("654").text("四湖"));		
		$("#cityArea").append($("<option></option>").val("655").text("元長"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"嘉義市":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("600").text("嘉義市"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"嘉義縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("602").text("番路"));		
		$("#cityArea").append($("<option></option>").val("603").text("梅山"));		
		$("#cityArea").append($("<option></option>").val("604").text("竹崎"));		
		$("#cityArea").append($("<option></option>").val("605").text("阿里山"));		
		$("#cityArea").append($("<option></option>").val("606").text("中埔"));		
		$("#cityArea").append($("<option></option>").val("607").text("大埔"));		
		$("#cityArea").append($("<option></option>").val("608").text("水上"));		
		$("#cityArea").append($("<option></option>").val("611").text("鹿草"));		
		$("#cityArea").append($("<option></option>").val("612").text("太保"));		
		$("#cityArea").append($("<option></option>").val("613").text("朴子"));		
		$("#cityArea").append($("<option></option>").val("614").text("東石"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"臺南市":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("700").text("中西區")); 	
		$("#cityArea").append($("<option></option>").val("701").text("東區"));		
		$("#cityArea").append($("<option></option>").val("702").text("南區"));		
		$("#cityArea").append($("<option></option>").val("704").text("北區"));		
		$("#cityArea").append($("<option></option>").val("708").text("安平區"));		
		$("#cityArea").append($("<option></option>").val("709").text("安南區"));		
		$("#cityArea").append($("<option></option>").val("710").text("永康區"));		
		$("#cityArea").append($("<option></option>").val("711").text("歸仁區"));		
		$("#cityArea").append($("<option></option>").val("712").text("新化區"));		
		$("#cityArea").append($("<option></option>").val("713").text("左鎮區"));		
		$("#cityArea").append($("<option></option>").val("714").text("玉井區"));		
		$("#cityArea").append($("<option></option>").val("715").text("楠西區"));		
		$("#cityArea").append($("<option></option>").val("716").text("南化區"));		
		$("#cityArea").append($("<option></option>").val("717").text("仁德區"));		
		$("#cityArea").append($("<option></option>").val("718").text("關廟區"));		
		$("#cityArea").append($("<option></option>").val("719").text("龍崎區"));		
		$("#cityArea").append($("<option></option>").val("720").text("官田區"));		
		$("#cityArea").append($("<option></option>").val("721").text("麻豆區"));		
		$("#cityArea").append($("<option></option>").val("722").text("佳里區"));		
		$("#cityArea").append($("<option></option>").val("723").text("西港區"));		
		$("#cityArea").append($("<option></option>").val("724").text("七股區"));		 	
		$("#cityArea").append($("<option></option>").val("725").text("將軍區"));		
		$("#cityArea").append($("<option></option>").val("726").text("學甲區"));		
		$("#cityArea").append($("<option></option>").val("727").text("北門區"));		
		$("#cityArea").append($("<option></option>").val("730").text("新營區"));		
		$("#cityArea").append($("<option></option>").val("731").text("後壁區"));		
		$("#cityArea").append($("<option></option>").val("732").text("白河區"));		
		$("#cityArea").append($("<option></option>").val("733").text("東山區"));		
		$("#cityArea").append($("<option></option>").val("734").text("六甲區"));		
		$("#cityArea").append($("<option></option>").val("735").text("下營區"));		
		$("#cityArea").append($("<option></option>").val("736").text("柳營區"));		
		$("#cityArea").append($("<option></option>").val("737").text("鹽水區"));		
		$("#cityArea").append($("<option></option>").val("741").text("善化區"));		
		$("#cityArea").append($("<option></option>").val("742").text("大內區"));		
		$("#cityArea").append($("<option></option>").val("743").text("山上區"));		
		$("#cityArea").append($("<option></option>").val("744").text("新市區"));		
		$("#cityArea").append($("<option></option>").val("745").text("安定區"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"高雄市":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("800").text("新興區"));		
		$("#cityArea").append($("<option></option>").val("801").text("前金區"));		
		$("#cityArea").append($("<option></option>").val("802").text("苓雅區"));		
		$("#cityArea").append($("<option></option>").val("803").text("鹽埕區"));		
		$("#cityArea").append($("<option></option>").val("804").text("鼓山區"));		
		$("#cityArea").append($("<option></option>").val("805").text("旗津區"));		
		$("#cityArea").append($("<option></option>").val("806").text("前鎮區"));		
		$("#cityArea").append($("<option></option>").val("807").text("三民區"));		
		$("#cityArea").append($("<option></option>").val("811").text("楠梓區"));		
		$("#cityArea").append($("<option></option>").val("812").text("小港區"));		
		$("#cityArea").append($("<option></option>").val("813").text("左營區"));		
		$("#cityArea").append($("<option></option>").val("814").text("仁武區"));		
		$("#cityArea").append($("<option></option>").val("815").text("大社區"));		
		$("#cityArea").append($("<option></option>").val("820").text("岡山區"));		
		$("#cityArea").append($("<option></option>").val("821").text("路竹區"));		
		$("#cityArea").append($("<option></option>").val("822").text("阿蓮區"));		
		$("#cityArea").append($("<option></option>").val("823").text("田寮區"));		
		$("#cityArea").append($("<option></option>").val("824").text("燕巢區"));		
		$("#cityArea").append($("<option></option>").val("825").text("橋頭區"));		
		$("#cityArea").append($("<option></option>").val("826").text("梓官區"));		
		$("#cityArea").append($("<option></option>").val("827").text("彌陀區"));		
		$("#cityArea").append($("<option></option>").val("828").text("永安區"));		
		$("#cityArea").append($("<option></option>").val("829").text("湖內區"));		
		$("#cityArea").append($("<option></option>").val("830").text("鳳山區"));		
		$("#cityArea").append($("<option></option>").val("831").text("大寮區"));		
		$("#cityArea").append($("<option></option>").val("832").text("林園區"));		
		$("#cityArea").append($("<option></option>").val("833").text("鳥松區"));		
		$("#cityArea").append($("<option></option>").val("840").text("大樹區"));		
		$("#cityArea").append($("<option></option>").val("842").text("旗山區"));		
		$("#cityArea").append($("<option></option>").val("843").text("美濃區"));		
		$("#cityArea").append($("<option></option>").val("844").text("六龜區"));		
		$("#cityArea").append($("<option></option>").val("845").text("內門區"));		
		$("#cityArea").append($("<option></option>").val("846").text("杉林區"));		
		$("#cityArea").append($("<option></option>").val("847").text("甲仙區"));		
		$("#cityArea").append($("<option></option>").val("848").text("桃源區"));		
		$("#cityArea").append($("<option></option>").val("849").text("那瑪夏區"));		
		$("#cityArea").append($("<option></option>").val("851").text("茂林區"));		
		$("#cityArea").append($("<option></option>").val("852").text("茄萣區"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"屏東縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("900").text("屏東"));		
		$("#cityArea").append($("<option></option>").val("901").text("三地門"));		
		$("#cityArea").append($("<option></option>").val("902").text("霧臺"));		
		$("#cityArea").append($("<option></option>").val("903").text("瑪家"));		
		$("#cityArea").append($("<option></option>").val("904").text("九如"));		
		$("#cityArea").append($("<option></option>").val("905").text("里港"));		
		$("#cityArea").append($("<option></option>").val("906").text("高樹"));		
		$("#cityArea").append($("<option></option>").val("907").text("鹽埔"));		
		$("#cityArea").append($("<option></option>").val("908").text("長治"));		
		$("#cityArea").append($("<option></option>").val("909").text("麟洛"));		
		$("#cityArea").append($("<option></option>").val("911").text("竹田"));		
		$("#cityArea").append($("<option></option>").val("912").text("內埔"));		
		$("#cityArea").append($("<option></option>").val("913").text("萬丹"));		
		$("#cityArea").append($("<option></option>").val("920").text("潮州"));		
		$("#cityArea").append($("<option></option>").val("921").text("泰武"));		
		$("#cityArea").append($("<option></option>").val("922").text("來義"));		
		$("#cityArea").append($("<option></option>").val("923").text("萬巒"));		
		$("#cityArea").append($("<option></option>").val("924").text("崁頂"));		
		$("#cityArea").append($("<option></option>").val("925").text("新埤"));		
		$("#cityArea").append($("<option></option>").val("926").text("南州"));		
		$("#cityArea").append($("<option></option>").val("927").text("林邊"));		
		$("#cityArea").append($("<option></option>").val("928").text("東港"));		
		$("#cityArea").append($("<option></option>").val("929").text("琉球"));		
		$("#cityArea").append($("<option></option>").val("931").text("佳冬"));		
		$("#cityArea").append($("<option></option>").val("932").text("新園"));		
		$("#cityArea").append($("<option></option>").val("940").text("枋寮"));		
		$("#cityArea").append($("<option></option>").val("941").text("枋山"));		
		$("#cityArea").append($("<option></option>").val("942").text("春日"));		
		$("#cityArea").append($("<option></option>").val("943").text("獅子"));		
		$("#cityArea").append($("<option></option>").val("944").text("車城"));		
		$("#cityArea").append($("<option></option>").val("945").text("牡丹"));		
		$("#cityArea").append($("<option></option>").val("946").text("恆春"));		
		$("#cityArea").append($("<option></option>").val("947").text("滿州"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"臺東縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("950").text("臺東"));		
		$("#cityArea").append($("<option></option>").val("951").text("綠島"));		
		$("#cityArea").append($("<option></option>").val("952").text("蘭嶼"));		
		$("#cityArea").append($("<option></option>").val("953").text("延平"));		
		$("#cityArea").append($("<option></option>").val("954").text("卑南"));		
		$("#cityArea").append($("<option></option>").val("955").text("鹿野"));		
		$("#cityArea").append($("<option></option>").val("956").text("關山"));		
		$("#cityArea").append($("<option></option>").val("957").text("海端"));		
		$("#cityArea").append($("<option></option>").val("958").text("池上"));		
		$("#cityArea").append($("<option></option>").val("959").text("東河"));		
		$("#cityArea").append($("<option></option>").val("961").text("成功"));		
		$("#cityArea").append($("<option></option>").val("962").text("長濱"));		
		$("#cityArea").append($("<option></option>").val("963").text("太麻里"));		
		$("#cityArea").append($("<option></option>").val("964").text("金峰"));		
		$("#cityArea").append($("<option></option>").val("965").text("大武"));		
		$("#cityArea").append($("<option></option>").val("966").text("達仁"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"花蓮縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("970").text("花蓮"));		
		$("#cityArea").append($("<option></option>").val("971").text("新城"));		
		$("#cityArea").append($("<option></option>").val("972").text("秀林"));		
		$("#cityArea").append($("<option></option>").val("973").text("吉安"));		
		$("#cityArea").append($("<option></option>").val("974").text("壽豐"));		
		$("#cityArea").append($("<option></option>").val("975").text("鳳林"));		
		$("#cityArea").append($("<option></option>").val("976").text("光復"));		
		$("#cityArea").append($("<option></option>").val("977").text("豐濱"));		
		$("#cityArea").append($("<option></option>").val("978").text("瑞穗"));		
		$("#cityArea").append($("<option></option>").val("979").text("萬榮"));		
		$("#cityArea").append($("<option></option>").val("981").text("玉里"));		
		$("#cityArea").append($("<option></option>").val("982").text("卓溪"));		
		$("#cityArea").append($("<option></option>").val("983").text("富里"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"宜蘭縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("260").text("宜蘭"));		
		$("#cityArea").append($("<option></option>").val("261").text("頭城"));		
		$("#cityArea").append($("<option></option>").val("262").text("礁溪"));		
		$("#cityArea").append($("<option></option>").val("263").text("壯圍"));		
		$("#cityArea").append($("<option></option>").val("264").text("員山"));		
		$("#cityArea").append($("<option></option>").val("265").text("羅東"));		
		$("#cityArea").append($("<option></option>").val("266").text("三星"));		
		$("#cityArea").append($("<option></option>").val("267").text("大同"));		
		$("#cityArea").append($("<option></option>").val("268").text("五結"));		
		$("#cityArea").append($("<option></option>").val("269").text("冬山"));		
		$("#cityArea").append($("<option></option>").val("270").text("蘇澳"));		
		$("#cityArea").append($("<option></option>").val("272").text("南澳"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"澎湖縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("880").text("馬公"));		
		$("#cityArea").append($("<option></option>").val("881").text("西嶼"));		
		$("#cityArea").append($("<option></option>").val("882").text("望安"));		
		$("#cityArea").append($("<option></option>").val("883").text("七美"));		
		$("#cityArea").append($("<option></option>").val("884").text("白沙"));		
		$("#cityArea").append($("<option></option>").val("885").text("湖西"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"金門縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("890").text("金沙"));		
		$("#cityArea").append($("<option></option>").val("891").text("金湖"));		
		$("#cityArea").append($("<option></option>").val("892").text("金寧"));		
		$("#cityArea").append($("<option></option>").val("893").text("金城"));		
		$("#cityArea").append($("<option></option>").val("894").text("烈嶼"));		
		$("#cityArea").append($("<option></option>").val("896").text("烏坵"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	case"連江縣":	
		$("#cityArea").empty();$("#cityArea").append($("<option></option>").val("209").text("南竿"));		
		$("#cityArea").append($("<option></option>").val("210").text("北竿"));		
		$("#cityArea").append($("<option></option>").val("211").text("莒光"));		
		$("#cityArea").append($("<option></option>").val("212").text("東引"));		
		$("#postal_code").val($("#cityArea").val());
		break;
	}
}

function cityAreaChange(cityArea) {
	$("#postal_code").val(cityArea);
}