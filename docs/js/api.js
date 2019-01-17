const PROXY_CORS = 'https://cors-anywhere.herokuapp.com/';
const TEST_AUTHKEY_URL = 'https://tosamara.ru/test_files/api/handler.php';
const API_URL = "https://tosamara.ru/api/v2/json";

function getTestAuthKey(message) {
    const formData = new FormData();
    formData.append('msg', message);
    let result;
    $.ajax({
        url: PROXY_CORS + TEST_AUTHKEY_URL,
        data: formData,
        processData: false,
        contentType: false,
        method: 'POST',
        async: false,
        success: function (testKey) {
            result = testKey;
        },
        error: function (message) {
            result = message;
        }
    });
    return result;
}

function getFirstArrivalToStop(ksIds, count) {
    let msg = {
        method: 'getFirstArrivalToStop',
        KS_ID: ksIds,
        COUNT: count
    };
    const message = JSON.stringify(msg);
    const authKey = getTestAuthKey(message);
    const formData = new FormData();
    formData.append('clientId', 'test');
    formData.append('authKey', authKey);
    formData.append('os', 'web');
    formData.append('message', message);
    let result;
    $.ajax({
        url: PROXY_CORS + API_URL,
        data: formData,
        processData: false,
        contentType: false,
        method: 'POST',
        async: false,
        success: function (data) {
            result = data;
        },
        error: function (error) {
            result = error;
        }
    });
    return result;
}