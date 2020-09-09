package book.infrastructure.datasource.loan;

import book.application.repository.LoanRepository;
import book.domain.model.item.ItemNumber;
import book.domain.model.loan.loan.Loan;
import book.domain.model.loan.loan.LoanRequest;
import book.domain.model.loan.loan.Loans;
import book.domain.model.loan.returned.Returned;
import book.domain.model.loan.rule.LoanStatus;
import book.domain.model.member.Member;
import book.domain.model.member.MemberNumber;
import book.domain.type.date.CurrentDate;
import book.infrastructure.datasource.item.ItemMapper;
import book.infrastructure.datasource.member.MemberMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LoanDataSource implements LoanRepository {
    LoanMapper loanMapper;
    ItemMapper itemMapper;
    MemberMapper memberMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public LoanDataSource(LoanMapper loanMapper, ItemMapper itemMapper, MemberMapper memberMapper) {
        this.loanMapper = loanMapper;
        this.itemMapper = itemMapper;
        this.memberMapper = memberMapper;
    }

    @Override
    @Transactional
    public void loan(LoanRequest loanRequest) {
        ItemNumber itemNumber = loanRequest.itemNumber();

        if (loanMapper.selectByItemNumber(itemNumber).isPresent()) {
            throw new RegisterLoanException(loanRequest);
        }

        int loanNumber = loanMapper.newLoanNumber();
        loanMapper.insertLoan(
                loanNumber,
                loanRequest.memberNumber(),
                itemNumber,
                loanRequest.loanDate());

        itemMapper.delete貸出可能(itemNumber);
        itemMapper.insert貸出中(itemNumber);
    }

    @Override
    @Transactional
    public void returned(Returned returned) {
        ItemNumber itemNumber = returned.itemNumber();
        Loan loan = loanMapper.selectByItemNumber(itemNumber)
                .orElseThrow(() -> new IllegalArgumentException(String.format("現在貸し出されていない蔵書です。蔵書番号：%s", itemNumber)));
        loanMapper.insertReturnBook(loan.loanNumber(), returned);

        itemMapper.insert貸出可能(itemNumber);
        itemMapper.delete貸出中(itemNumber);
    }


    @Override
    public LoanStatus status(MemberNumber memberNumber) {
        List<Loan> loans = loanMapper.selectByMemberNumber(memberNumber);
        Member member = memberMapper.selectMember(memberNumber);
        return new LoanStatus(member, new Loans(loans), new CurrentDate(LocalDate.now()));
    }

    @Override
    public Loan findBy(ItemNumber itemNumber) {
        return loanMapper.selectByItemNumber(itemNumber).orElseThrow(() ->
                new IllegalArgumentException(String.format("現在貸し出されていない蔵書です。蔵書番号：%s", itemNumber)));
    }
}
