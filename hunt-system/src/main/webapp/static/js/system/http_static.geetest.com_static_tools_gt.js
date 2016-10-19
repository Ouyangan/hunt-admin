(function (window, document) {

    if (window.initGeetest) {
        return;
    }
    var head = document.getElementsByTagName("head")[0];
    var protocol = location.protocol + "//";
    var callbacks = [];
    var status = "init";
    var random = function () {
        return parseInt(Math.random() * 10000) + (new Date()).valueOf();
    };
    var run = function () {
        for (var i = 0, len = callbacks.length; i < len; i = i + 1) {
            callbacks[i]();
        }
        callbacks = [];
    };
    var detect = function () {
        return window.Geetest || document.getElementById("gt_lib");
    };
    var down = function (config) {
        var s = document.createElement("script");
        s.charset = "UTF-8";
        s.type = "text/javascript";
        s.onload = s.onreadystatechange = function () {
            if (!this.readyState || this.readyState === "loaded" || this.readyState === "complete") {
                if (detect()) {
                    status = "loaded";
                    run();
                } else {
                    status = "fail";
                    if (typeof config.onError === 'function') {
                        config.onError();
                    } else {
                        throw new Error("网络错误");
                    }
                }
                s.onload = s.onreadystatechange = null;
            }
        };
        s.onerror = function () {
            status = "fail";
            s.onerror = null;

            if (typeof config.onError === 'function') {
                config.onError();
            } else {
                throw new Error("网络错误");
            }
        };
        var staticServer = (config.staticservers && config.staticservers[0]) || "static.geetest.com/";
        s.src = protocol + staticServer + "static/js/geetest.0.0.0.js";
        head.appendChild(s);
    };

    var getLib = function (config) {
        status = "loading";
        var cb = "geetest_" + random();
        window[cb] = function (newConfig) {
            status = "loaded";
            if (newConfig) {
                config.type = newConfig.type;
            }
            run();
            window[cb] = undefined;
            try {
                delete window[cb];
            } catch (e) {
            }
        };
        var s = document.createElement("script");
        s.charset = "UTF-8";
        s.type = "text/javascript";
        s.onload = s.onreadystatechange = function () {
            if (!this.readyState || this.readyState === "loaded" || this.readyState === "complete") {
                if (!detect()) {
                    down(config);
                }
            }
        };
        s.onerror = function () {
            down(config);
        };
        var apiServer = config.apiserver || "api.geetest.com/";
        s.src = protocol + apiServer + "getfrontlib.php?gt=" + config.gt + "&callback=" + cb;
        head.appendChild(s);
    };

    if (detect()) {
        status = "loaded";
    }

    window.initGeetest = function (config, callback) {
        if (typeof config.gt !== "string") {
            throw new Error("initGeetest接口配置参数gt错误")
        }
        var init = function () {
            callback(new window.Geetest(config));
        };
        if (status === "loaded") {
            init();
        } else if (status === "fail") {
            if (typeof config.onError === 'function') {
                config.onError();
            } else {
                throw new Error("网络错误");
            }
        } else if (status === "loading") {
            callbacks.push(function () {
                init();
            });
        } else if (status === "init") {
            callbacks.push(function () {
                init();
            });
            getLib(config);
        }
    };

})(window, document);

