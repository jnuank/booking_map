package book.infrastructure.datasource.member;

import book.domain.model.member.Member;
import book.domain.model.member.MemberNumber;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    boolean exists(MemberNumber memberNumber);

    Member selectMember(MemberNumber memberNumber);
}
