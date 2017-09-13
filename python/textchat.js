/**
 * Created by hanqian18790 on 2017/6/12.
 * hi
 */
var num = 0;
function chat() {
    num++;

    switch (words) {
        case "你好":
            return "你好";
        case "你是谁":
            return "我是你爸爸";
        case "傻逼":
            return "傻逼";
        case "hello":
            return "hello bitch";
        case "hi":
            return "hello world";
        case "刷新没":
            return "你看看" + num;
        case "吃饭":
            return eat();
        default :
            return "输入以下消息：\n" +
                "你好：\n" +
                "你是谁\n" +
                "傻逼\n" +
                "hello\n" +
                "hi";

    }
}

//吃饭函数
function eat() {
    var eat = "瞎JB吃";
    var direction = 0;
    direction = parseInt(Math.random() * 10 % 3);
    var number = 1;
    number = parseInt(Math.random() * 10 % 5);
    if (direction == 0) {
        eat = "左边第" + number + "个";
    } else if (direction == 1) {
        eat = "右边第" + number + "个";
    }
    else {
        return eat;
    }
    return eat;
}
