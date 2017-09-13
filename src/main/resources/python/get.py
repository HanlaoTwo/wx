# -*- coding:utf-8 -*-
import requests
import re

header = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:47.0) Gecko/20100101 Firefox/47.0',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Language': 'en-US,en;q=0.5',
    'Accept-Encoding': 'gzip, deflate, br'
}
proxies = {"http": "http://"+'125.88.74.123:81'}
douban = 'https://www.douban.com/group/hangzhou/discussion?start='
url_rule = '<td class=\"title\">.*?<a href=\"(.*?)\" title=\".*?\" class=\"\">.*?<\/a>.*?<\/td>'
name_rule = '<a href="https://www.douban.com/people/.*?/" class="">(.*?)</a>'

starts = ['0','25','50','75','100','125','150','175','200']
for start in starts:
    index_html = requests.get(url=douban + start, headers=header, proxies=proxies)
    print('结果：', index_html.status_code)
    print('原因：', index_html.reason)

    url_patten = re.compile(url_rule, re.S)
    urls = re.findall(url_patten, index_html.text)
    #print(index_html.text)
    #print(urls)
    for url in urls:
        print('---------', url)

    for toipc in urls:
        topichtml = requests.get(url=toipc, headers=header,proxies = proxies)
        name_patten = re.compile(name_rule, re.S)
        names = re.findall(name_patten, topichtml.text)
        print('>>>>>>>>', len(names))
        print(names)
        for name in names:
            if (name=='、、'):
                print(name + ": " + toipc)