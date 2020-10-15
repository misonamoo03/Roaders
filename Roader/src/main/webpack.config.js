const VueLoaderPlugin = require('vue-loader/lib/plugin')
const path = require('path');

module.exports = {
     context: path.resolve(__dirname, 'front'),
   entry : {
     home:'./home.js',
     detail: './Delivery/detail.js',
     tracking:'./Delivery/Tracking.js',
     DeliveryList : './Delivery/List.js',     
     point:'./point/point.js'
   },
   module : {
      rules: [
         {
            test: /\.vue$/,
            loader: 'vue-loader',
            options: {
            // `vue-loader` 옵션
            }
         }
      ]

   },
   plugins : [
      new VueLoaderPlugin()
   ],
   output : {
      filename :'[name].js',
      path : path.join(__dirname,'webapp/resources')
   },
   devServer: {
        contentBase:path.resolve(__dirname,'html'),
        inline: true,
        hot: true,
        host: "localhost",
        port: 5500
    },
};