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

package net.luoteng.coupon.service;

import java.awt.print.Pageable;
import java.util.List;
import net.luoteng.coupon.entity.CouponPackage;
import net.luoteng.coupon.enums.CouponType;
import org.springframework.data.domain.Page;

/**
 * coupon service
 *
 * @author suetming <suetming.ma at gmail.com>
 * Copyright(c) @2016 Luoteng Company, Inc.  All Rights Reserved.
 */
public interface CouponService {
    
    /**
     * 列出所有package
     * 
     * @param typeList
     * @param pageable
     * @return 
     */
    Page<CouponPackage> listPackage(List<CouponType> typeList, Pageable pageable);

    /**
     * 新增或者更新奖券包
     *
     * @param couponPackage
     * @return 
     */
    CouponPackage savePackage(CouponPackage couponPackage);
}
