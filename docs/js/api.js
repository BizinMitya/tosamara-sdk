const PROXY_CORS = 'https://cors-anywhere.herokuapp.com/';
const TEST_AUTHKEY_URL = 'https://tosamara.ru/test_files/api/handler.php';

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





