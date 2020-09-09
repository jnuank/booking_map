package book.infrastructure.datasource.loan;

import book.domain.model.item.ItemNumber;
import book.domain.model.loan.loan.Loan;
import book.domain.model.loan.loan.LoanDate;
import book.domain.model.loan.loan.LoanNumber;
import book.domain.model.loan.returned.Returned;
import book.domain.model.member.MemberNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LoanMapper {
    int newLoanNumber();

    List<Loan> selectByMemberNumber(@Param("memberNumber") MemberNumber memberNumber);

    void insertLoan(
            @Param("loanNumber") int loanNumber,
            @Param("memberNumber") MemberNumber memberNumber,
            @Param("itemNumber") ItemNumber itemNumber,
            @Param("loanDate") LoanDate loanDate);

    void insertReturnBook(
            @Param("loanNumber") LoanNumber loanNumber,
            @Param("returned") Returned returned);

    Optional<Loan> selectByItemNumber(@Param("itemNumber") ItemNumber itemNumber);

    List<Loan> selectByItemNumbers(@Param("itemNumbers") List<ItemNumber> itemNumbers);

    List<Returned> selectReturnedByItemNumbers(@Param("itemNumbers") List<ItemNumber> itemNumbers);
}
