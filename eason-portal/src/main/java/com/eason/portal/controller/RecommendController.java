//package com.eason.portal.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author colin
// */
//public class RecommendController {
//    @Autowired
//    private OrderService orderService;
//
//    private static final String modelpath = "c://text/tesf.txt";
//
//    @RequestMapping("recomendControlbyscan")
//    public  List<Integer> recomendControlbyscan(Integer userid,Integer productid,int recomendnums){
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        return list;
////        SparkConf conf = new SparkConf().setAppName("recomendControlbyscan");
////        JavaSparkContext jsc = new JavaSparkContext(conf);
////        MatrixFactorizationModel sameModel = MatrixFactorizationModel.load(jsc.sc(),
////                modelpath);
////        List<Tuple2<Integer,Integer>> sourclist = new ArrayList<Tuple2<Integer,Integer>>();
////        Tuple2<Integer,Integer> tuple2 = new Tuple2<Integer,Integer>(userid,productid);
////        sourclist.add(tuple2);
////        JavaPairRDD<Integer,Integer> sourcerdd = jsc.parallelizePairs(sourclist);
////        JavaRDD<Rating> result = sameModel.predict(sourcerdd);
////        List<Rating> list = result.collect();
////        List<MyScore> sortList = new ArrayList<MyScore>();
////        for(Rating rating:list){
////            int product = rating.product();
////            int user = rating.user();
////            double ratingdouble = rating.rating();
////            MyScore myScore = new MyScore(user,product,ratingdouble);
////            sortList.add(myScore);
////        }
////        Collections.sort(sortList);
////
////        List<Integer> resultproduct = new ArrayList<Integer>();
////        int count = 0;
////        for(MyScore myScore: sortList){
////                if(count < recomendnums){
////                    Integer product = myScore.product();
////                    resultproduct.add(product);
////                }
////                count++;
////        }
////        return resultproduct;
//    }
//
//    @CrossOrigin(origins = {"http://127.0.0.1:8082", "null"})
//    @RequestMapping("recomendControlbyorder")
//    public List<Integer> recomendControlbyorder(int userid, int recomendnums){
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        return list;
////        List<Tuple2<Integer,Integer>> sourclist = new ArrayList<Tuple2<Integer,Integer>>();
////
////        List<OrderDetail> orderdetiallist = orderService.listOrderDetailbyuserid(userid);
////        for(OrderDetail order :orderdetiallist){
////            int productid = order.getProductid();
////            Tuple2<Integer,Integer> tuple2 = new Tuple2<Integer,Integer>(userid,productid);
////            sourclist.add(tuple2);
////        }
////
////        SparkConf conf = new SparkConf().setAppName("recomendControlbyorder");
////        JavaSparkContext jsc = new JavaSparkContext(conf);
////        MatrixFactorizationModel sameModel = MatrixFactorizationModel.load(jsc.sc(),
////                modelpath);
////
////        JavaPairRDD<Integer,Integer> sourcerdd = jsc.parallelizePairs(sourclist);
////        JavaRDD<Rating> result = sameModel.predict(sourcerdd);
////        List<Rating> list = result.collect();
////        List<MyScore> sortList = new ArrayList<MyScore>();
////        for(Rating rating:list){
////            int product = rating.product();
////            int user = rating.user();
////            double ratingdouble = rating.rating();
////            MyScore myScore = new MyScore(user,product,ratingdouble);
////            sortList.add(myScore);
////        }
////        Collections.sort(sortList);
////
////        List<Integer> resultproduct = new ArrayList<Integer>();
////        int count = 0;
////        for(MyScore myScore: sortList){
////            if(count < recomendnums){
////                Integer product = myScore.product();
////                resultproduct.add(product);
////            }
////            count++;
////        }
////        return resultproduct;
//    }
//}
//
//class MyScore extends Rating implements Comparable<MyScore>{
//    public MyScore(int user,int product, double rating) {
//        super(user, product, rating);
//    }
//
//    @Override
//    public int compareTo(MyScore o) {
//        if(o.rating()-this.rating()  >0){
//            return 1;
//        }else if(o.rating()-this.rating()  <0){
//            return -1;
//        }
//        return 0;
//    }
//
//
//
//    public static void main(String[] args) {
//        MyScore myScore = new MyScore(1,1,0.2);
//        MyScore myScore2 = new MyScore(1,2,0.3);
//        List<MyScore> list = new ArrayList<MyScore>();
//        list.add(myScore);
//        list.add(myScore2);
//        for(MyScore myScoretemp:list){
//            System.out.println("排序前=="+myScoretemp.product());
//        }
//        Collections.sort(list);
//        for(MyScore myScoretemp:list){
//            System.out.println("排序后=="+myScoretemp.product());
//        }
//
//    }
//}
//
