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

package net.luoteng.user.dao;

import javax.transaction.Transactional;
import net.luoteng.user.entity.SocialUser;
import net.luoteng.user.enums.SocialType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * social user
 *
 * @author suetming <suetming.ma at gmail.com>
 * Copyright(c) @2016 Luoteng Company, Inc.  All Rights Reserved.
 */
@Transactional
public interface SocialUserDAO extends PagingAndSortingRepository<SocialUser, String>{

    @Query("select u from SocialUser u where u.userId=:userId and u.type=:type")
    SocialUser getByUser(@Param("userId") String userId, @Param("type") SocialType type);

    @Query("select u from SocialUser u where u.clientId=:clientId and u.type=:type")
    SocialUser getBySocial(@Param("clientId") String clientId, @Param("type") SocialType type);

}
