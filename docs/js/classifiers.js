const CLASSIFIERS_URL = "https://tosamara.ru/api/classifiers";
const STOPS_URL = CLASSIFIERS_URL + "/stops.xml";
const STOPS_FULL_URL = CLASSIFIERS_URL + "/stopsFullDB.xml";
const ROUTES_URL = CLASSIFIERS_URL + "/routes.xml";
const ROUTES_AND_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/routesAndStopsCorrespondence.xml";
const GEOPORTAL_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/GeoportalStopsCorrespondence.xml";
const GEOPORTAL_ROUTES_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/GeoportalRoutesCorrespondence.xml";

function doClassifierRequest(url, handler, callback) {
    $.ajax({
        url: url,
        dataType: "xml",
        cache: false,
        success: function (classifiers) {
            let result = handler(classifiers);
            callback(result);
        }
    });
}

function handleGetClassifiersResponse(classifiers) {
    let result = [];
    $(classifiers).find('file').each(function () {
        let name = $(this).attr('name');
        let modified = $(this).find('modified').text();
        result.push({name: name, modified: modified});
    });
    return result;
}

function getClassifiers(callback) {
    doClassifierRequest(PROXY_CORS + CLASSIFIERS_URL, handleGetClassifiersResponse, callback);
}

function handleGetStopsResponse(stops) {
    let result = [];
    $(stops).find('stop').each(function () {
        let ksId = $(this).find('KS_ID').text();
        let title = $(this).find('title').text();
        let adjacentStreet = $(this).find('adjacentStreet').text();
        let direction = $(this).find('direction').text();
        let titleEn = $(this).find('titleEn').text();
        let adjacentStreetEn = $(this).find('adjacentStreetEn').text();
        let directionEn = $(this).find('directionEn').text();
        let titleEs = $(this).find('titleEs').text();
        let adjacentStreetEs = $(this).find('adjacentStreetEs').text();
        let directionEs = $(this).find('directionEs').text();
        result.push({
            ksId: ksId,
            title: title,
            adjacentStreet: adjacentStreet,
            direction: direction,
            titleEn: titleEn,
            adjacentStreetEn: adjacentStreetEn,
            directionEn: directionEn,
            titleEs: titleEs,
            adjacentStreetEs: adjacentStreetEs,
            directionEs: directionEs
        });
    });
    return result;
}

function getStops(callback) {
    doClassifierRequest(PROXY_CORS + STOPS_URL, handleGetStopsResponse, callback);
}

function handleGetFullStopsResponse(fullStops) {
    let result = [];
    $(fullStops).find('stop').each(function () {
        let ksId = $(this).find('KS_ID').text();
        let title = $(this).find('title').text();
        let adjacentStreet = $(this).find('adjacentStreet').text();
        let direction = $(this).find('direction').text();
        let titleEn = $(this).find('titleEn').text();
        let adjacentStreetEn = $(this).find('adjacentStreetEn').text();
        let directionEn = $(this).find('directionEn').text();
        let titleEs = $(this).find('titleEs').text();
        let adjacentStreetEs = $(this).find('adjacentStreetEs').text();
        let directionEs = $(this).find('directionEs').text();
        let cluster = $(this).find('cluster').text();
        let busesMunicipal = $(this).find('busesMunicipal').text();
        if (busesMunicipal !== "") {
            busesMunicipal = busesMunicipal.split(', ');
        }
        let busesCommercial = $(this).find('busesCommercial').text();
        if (busesCommercial !== "") {
            busesCommercial = busesCommercial.split(', ');
        }
        let busesPrigorod = $(this).find('busesPrigorod').text();
        if (busesPrigorod !== "") {
            busesPrigorod = busesPrigorod.split(', ');
        }
        let busesSeason = $(this).find('busesSeason').text();
        if (busesSeason !== "") {
            busesSeason = busesSeason.split(', ');
        }
        let busesSpecial = $(this).find('busesSpecial').text();
        if (busesSpecial !== "") {
            busesSpecial = busesSpecial.split(', ');
        }
        let busesIntercity = $(this).find('busesIntercity').text();
        if (busesIntercity !== "") {
            busesIntercity = busesIntercity.split(', ');
        }
        let trams = $(this).find('trams').text();
        if (trams !== "") {
            trams = trams.split(', ');
        }
        let trolleybuses = $(this).find('trolleybuses').text();
        if (trolleybuses !== "") {
            trolleybuses = trolleybuses.split(', ');
        }
        let metros = $(this).find('metros').text();
        if (metros !== "") {
            metros = metros.split(', ');
        }
        let electricTrains = $(this).find('electricTrains').text();
        if (electricTrains !== "") {
            electricTrains = electricTrains.split(', ');
        }
        let riverTransports = $(this).find('riverTransports').text();
        if (riverTransports !== "") {
            riverTransports = riverTransports.split(', ');
        }
        let infotabloExists = $(this).find('infotabloExists').text();
        let latitude = $(this).find('latitude').text();
        let longitude = $(this).find('longitude').text();
        let angle = $(this).find('angle').text();
        result.push({
            ksId: ksId,
            title: title,
            adjacentStreet: adjacentStreet,
            direction: direction,
            titleEn: titleEn,
            adjacentStreetEn: adjacentStreetEn,
            directionEn: directionEn,
            titleEs: titleEs,
            adjacentStreetEs: adjacentStreetEs,
            directionEs: directionEs,
            cluster: cluster,
            busesMunicipal: busesMunicipal,
            busesCommercial: busesCommercial,
            busesPrigorod: busesPrigorod,
            busesSeason: busesSeason,
            busesSpecial: busesSpecial,
            busesIntercity: busesIntercity,
            trams: trams,
            trolleybuses: trolleybuses,
            metros: metros,
            electricTrains: electricTrains,
            riverTransports: riverTransports,
            infotabloExists: infotabloExists,
            latitude: latitude,
            longitude: longitude,
            angle: angle
        });
    });
    return result;
}

function getFullStops(callback) {
    doClassifierRequest(PROXY_CORS + STOPS_FULL_URL, handleGetFullStopsResponse, callback);
}

function handleGetRoutesResponse(routes) {
    let result = [];
    $(routes).find('route').each(function () {
        let krId = $(this).find('KR_ID').text();
        let number = $(this).find('number').text();
        let direction = $(this).find('direction').text();
        let directionEn = $(this).find('directionEn').text();
        let directionEs = $(this).find('directionEs').text();
        let transportTypeID = $(this).find('transportTypeID').text();
        let transportType = $(this).find('transportType').text();
        let affiliationID = $(this).find('affiliationID').text();
        let affiliation = $(this).find('affiliation').text();
        let realtimeForecast = $(this).find('realtimeForecast').text();
        result.push({
            krId: krId,
            number: number,
            direction: direction,
            directionEn: directionEn,
            directionEs: directionEs,
            transportTypeID: transportTypeID,
            transportType: transportType,
            affiliationID: affiliationID,
            affiliation: affiliation,
            realtimeForecast: realtimeForecast
        });
    });
    return result;
}

function getRoutes(callback) {
    doClassifierRequest(PROXY_CORS + ROUTES_URL, handleGetRoutesResponse, callback);
}

function handleGetRoutesWithStopsResponse(routesWithStops) {
    let result = [];
    $(routesWithStops).find('route').each(function () {
        let krId = $(this).find('KR_ID').text();
        let number = $(this).find('number').text();
        let direction = $(this).find('direction').text();
        let transportType = $(this).find('transportType');
        let transportTypeId = transportType.find('id').text();
        let transportTypeTitle = transportType.find('title').text();
        let performing = $(this).find('performing').text();
        let realtimeForecast = $(this).find('realtimeForecast').text();
        let stops = [];
        $(this).find('stop').each(function () {
            let ksId = $(this).find('KS_ID').text();
            let title = $(this).find('title').text();
            let adjacentStreet = $(this).find('adjacentStreet').text();
            let direction = $(this).find('direction').text();
            let scheduleTime = $(this).find('scheduleTime').text();
            stops.push({
                ksId: ksId,
                title: title,
                adjacentStreet: adjacentStreet,
                direction: direction,
                scheduleTime: scheduleTime
            });
        });
        result.push({
            krId: krId,
            number: number,
            direction: direction,
            transportType: {
                id: transportTypeId,
                title: transportTypeTitle
            },
            performing: performing,
            realtimeForecast: realtimeForecast,
            stops: stops
        });
    });
    return result;
}

function getRoutesWithStops(callback) {
    doClassifierRequest(PROXY_CORS + ROUTES_AND_STOPS_CORRESPONDENCE_URL, handleGetRoutesWithStopsResponse, callback);
}

function handleGetStopsOnMapResponse(stopsOnMap) {
    let layerName = $(stopsOnMap).find('layerName').text();
    let stops = [];
    $(stopsOnMap).find('stop').each(function () {
        let ksId = $(this).find('KS_ID').text();
        let geoportalId = $(this).find('geoportalId').text();
        let staticDescription = $(this).find('staticDescription').text();
        stops.push({
            ksId: ksId,
            geoportalId: geoportalId,
            staticDescription: staticDescription
        });
    });
    return {
        layerName: layerName,
        stops: stops
    };
}

function getStopsOnMap(callback) {
    doClassifierRequest(PROXY_CORS + GEOPORTAL_STOPS_CORRESPONDENCE_URL, handleGetStopsOnMapResponse, callback);
}

function handleGetRoutesOnMapResponse(routesOnMap) {
    let result = [];
    $(routesOnMap).find('route').each(function () {
        let krId = $(this).find('KR_ID').text();
        let geoportalId = $(this).find('geoportalId').text();
        let layerName = $(this).find('layerName').text();
        result.push({
            krId: krId,
            geoportalId: geoportalId,
            layerName: layerName
        });
    });
    return result;
}

function getRoutesOnMap(callback) {
    doClassifierRequest(PROXY_CORS + GEOPORTAL_ROUTES_CORRESPONDENCE_URL, handleGetRoutesOnMapResponse, callback);
}

