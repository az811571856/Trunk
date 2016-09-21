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
package net.luoteng.coupon.enums;

import lombok.Getter;
import net.luoteng.enums.BaseEnum;

/**
 * coupon type
 * @author suetming <suetming.ma at gmail.com>
 */
public enum CouponType implements BaseEnum {
    
    /**
     * 下单时代替部分现金
     * 
     */
    CASH("代金券"),
    
    /**
     * 针对金额打折
     */
    DISCOUNT("折扣券"),
    
    
    FREE("免费券");
    
    @Getter
    private final String msg;
    
    private CouponType(String msg) {
        this.msg = msg;
    }

}