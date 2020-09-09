package book.application.repository;

import book.domain.model.member.Member;
import book.domain.model.member.MemberNumber;
import book.domain.model.member.MemberStatus;

/**
 * 会員リポジトリ
 */
public interface MemberRepository {
    MemberStatus status(MemberNumber memberNumber);

    Member findBy(MemberNumber memberNumber);
}
