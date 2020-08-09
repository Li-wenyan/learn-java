import unittest,csv
import os,sys
import time
import HTMLTestRunner
def createsuite():
    discover = unittest.defaultTestLoader.discover('../Selenium2',pattern='test*.py',
                                                   top_level_dir=None)
    print(discover)
    return discover
if __name__=="__main__":
    curpath = sys.path[0]
    #取当前时间
    now = time.strftime("%Y-%m-%d-%H %M %S",time.localtime(time.time()))
    if not os.path.exists(curpath + '/resultreport'):
        os.makedirs(curpath + '/resultreport')
    filename = curpath + '/resultreport/' + now + 'resultreport.html'
    with open(filename,'wb') as fp:
        #出HTML报告结果
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,title=u'测试报告',
                                               description=u'用例执行情况',verbosity=2)
        suite = createsuite()
        #runner = unittest.TextTestRunner(verbosity=2)
        runner.run(suite)