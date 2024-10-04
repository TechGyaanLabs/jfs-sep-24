package com.careerit.cj.accessspecifiers.p2;

import com.careerit.cj.accessspecifiers.p1.C1;

public class C5 {

        public void showDetails(){
            C1 obj = new C1();
            System.out.println(obj.pub_a);
            // System.out.println(obj.pro_a);
            // System.out.println(obj.def_a);
            //System.out.println(obj.pri_a);
        }
}
