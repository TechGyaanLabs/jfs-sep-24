package com.careerit.cj.accessspecifiers.p1;

public class C1 {

        private int pri_a = 10;
        public int pub_a = 20;
        protected  int pro_a = 30;
        int def_a = 40;


        public void showDetails(){
            System.out.println(pub_a);
            System.out.println(pro_a);
            System.out.println(def_a);
            System.out.println(pri_a);
        }
}
