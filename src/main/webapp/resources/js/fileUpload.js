function checkImageType(fileName){
	
	var pattern = /jpg|gif|png|jpeg|/i;
	
	return fileName.match(pattern);
}

function getSocietyFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/society_display?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12);
		var end = fullName.substr(14);
		
		getLink = "/society_display?fileName=" + front + end;
	
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/society_display?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {
		fileName:fileName,
		imgsrc:imgsrc,
		getLink:getLink,
		fullName:fullName
	};
}

function getEnmFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/enm_display?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12);
		var end = fullName.substr(14);
		
		getLink = "/enm_display?fileName=" + front + end;
	
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/enm_display?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {
		fileName:fileName,
		imgsrc:imgsrc,
		getLink:getLink,
		fullName:fullName
	};
}

function getSportsFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/sports_display?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12);
		var end = fullName.substr(14);
		
		getLink = "/sports_display?fileName=" + front + end;
	
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/sports_display?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {
		fileName:fileName,
		imgsrc:imgsrc,
		getLink:getLink,
		fullName:fullName
	};
}

function getCultureFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/culture_display?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12);
		var end = fullName.substr(14);
		
		getLink = "/culture_display?fileName=" + front + end;
	
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/culture_display?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {
		fileName:fileName,
		imgsrc:imgsrc,
		getLink:getLink,
		fullName:fullName
	};
}

function getPeopleFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/people_display?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12);
		var end = fullName.substr(14);
		
		getLink = "/people_display?fileName=" + front + end;
	
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/people_display?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {
		fileName:fileName,
		imgsrc:imgsrc,
		getLink:getLink,
		fullName:fullName
	};
}

function getTechFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/tech_display?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12);
		var end = fullName.substr(14);
		
		getLink = "/tech_display?fileName=" + front + end;
	
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/tech_display?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {
		fileName:fileName,
		imgsrc:imgsrc,
		getLink:getLink,
		fullName:fullName
	};
}