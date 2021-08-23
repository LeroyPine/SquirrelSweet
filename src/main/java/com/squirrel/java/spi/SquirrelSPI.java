package com.squirrel.java.spi;

import javax.xml.ws.Service;
import java.util.ServiceLoader;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年04月29日 10:27
 * @since 1.0
 */
public class SquirrelSPI {


    public static void main(String[] args) {


        ServiceLoader<Search> load = ServiceLoader.load(Search.class);

        for (Search search : load) {
            search.search("test");
        }
    }
}
