# blackjack-backend
## 브랜치 전략
Git-flow사용  
main, develop, feature/\*, release/\*, hotfix/\*



# 객체 구성

### Card (카드 낱장)
    - 에이스인지 판별 한다
    - 기본카드? 

### Deck (카드 뭉치 56장) 
    - 


### Hands (손에 있는 카드)
    - 카드 추가
    - 블랙잭인지 판별
    - 21 초과인지 검사
    - 현재 가지고있는 카드의 합계 구하기
    - 에이스가 있는지 확인
    - 전체 제거
    - getCards

### Number
    - 2~10 JQKA 카드 값 정의 ENUM

### Pattern 
    - 4가지 카드 모양 ENUM


### Dealer
    - 카드 추가
    - 카드 계산
    - 카드 리셋
    - 다음 카드