/*
 * Copyright 2016 suetming <suetming.ma at gmail.com>.
 *
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 * To view a copy of this license, visit 
 *
 *      http://creativecommons.org/licenses/by-nc-nd/3.0/
 *
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, 
 * Mountain View, California, 94041, USA.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.luoteng.payment.model.enums.alipay;

import net.luoteng.enums.BaseEnum;

/**
 *
 * @author suetming <suetming.ma at gmail.com>
 */
public enum Service implements BaseEnum {

    /******** mobile **********/
    MOBILE_SECURITYPAY_PAY("mobile.securitypay.pay"),
    
    /********* web ************/
    CREATE_DIRECT_PAY_BY_USER("create_direct_pay_by_user"),
    
    /********* https://openapi.alipay.com/gateway.do **************/
    TRADE_QUERY("alipay.trade.query"),;

    private final String msg;
    
    Service(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String getMsg() {
        return msg;
    }
    
}
