package book.application.service.member;

import book.application.repository.MemberRepository;
import book.domain.model.member.Member;
import book.domain.model.member.MemberNumber;
import book.domain.model.member.MemberStatus;
import org.springframework.stereotype.Service;

/**
 * 会員参照サービス
 */
@Service
public class MemberQueryService {
    MemberRepository memberRepository;

    MemberQueryService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 会員を見つける
     */
    public Member findMember(MemberNumber memberNumber) {
        return memberRepository.findBy(memberNumber);
    }

    /**
     * 会員登録の状態を確認する
     */
    public MemberStatus status(MemberNumber memberNumber) {
        return memberRepository.status(memberNumber);
    }
}
