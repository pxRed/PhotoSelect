# PhotoSelect
一个仿qq 简易图片选择器 支持图片预览 放大缩小


使用recyclerview 设计的一个图片列表 

加载图片 用的 glide 提高图片加载效率

使用方法：

导入依赖库 photoselectorlibrary

使用 startActivityForResult启动图片选择器

 Intent it = new Intent(MainActivity.this, ImageSelectorListActivity.class);
                it.putExtra("type", 1);
                startActivityForResult(it, ImageSelectorListActivity.RESULT_OK);
                
  通过回调函数 接收返回的图片路径 
     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ImageSelectorListActivity.RESULT_OK) {
            if (data == null) return;
            ArrayList<String> filePath = data.getStringArrayListExtra("filePath");
            String str1 = "";
            for (String str : filePath) {
                str1 = str1 + str + "/n";
            }
            _tvText.setText(str1+"0");
        }
    }

其中 type 标识是单选还是多选
type=1 为单选  type=2为多选

详情请参考demo
效果图如下：
![image](https://github.com/a479889183/PhotoSelect/blob/master/image1.png )
![image](https://github.com/a479889183/PhotoSelect/blob/master/image2.png ) 
![image](https://github.com/a479889183/PhotoSelect/blob/master/image3.png ) 
![image](https://github.com/a479889183/PhotoSelect/blob/master/image4.png ) 
