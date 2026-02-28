// 연습문제 1: UserProfile 조건부 렌더링 (if-else 사용)
// 문제:
// 전달받은 user 객체의 유무에 따라 서로 다른 JSX 전체를 반환하는
//   UserProfile 컴포넌트를 작성하세요.

// 요구사항:
// 1. props.user가 존재하면: 사용자의 이름과 이메일이 담긴 UI를 반환합니다.
// 2. props.user가 없으면: "사용자 정보가 없습니다."라는 문구가 담긴 UI를 반환합니다.
// 3. if-else 문을 사용하여 리턴(return) 문 자체를 두 개로 분리하세요.

// 힌트:
// 함수형 컴포넌트 내부에서 if (조건) { return <A />; } else { return <B />; }
// 패턴을 사용하면 조건에 따라 컴포넌트의 렌더링 결과가 완전히 달라집니다.
import React from "react";

function UserProfile({ user }) {
  // 1. 데이터가 없을 때 먼저 리턴 (Early Return 패턴)
  if (!user) {
    return (
      <div style={{ padding: 16, backgroundColor: "#fff3f3", borderRadius: 8 }}>
        <p style={{ color: "#d32f2f" }}>
          사용자 정보가 없습니다. 로그인이 필요합니다.
        </p>
      </div>
    );
  } else {
    // 2. 데이터가 있을 때 리턴
    return (
      <div
        style={{ padding: 16, border: "1px solid #4caf50", borderRadius: 8 }}
      >
        <h2 style={{ margin: "0 0 8px 0", color: "#2e7d32" }}>{user.name}</h2>
        <p style={{ margin: 0, color: "#666" }}>{user.email}</p>
      </div>
    );
  }
}

// 사용 예시
export function UserProfileExample() {
  const userData = { name: "홍길동", email: "hong@example.com" };

  return (
    <div style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
      <h3>[데이터가 있는 경우]</h3>
      <UserProfile user={userData} />

      <h3>[데이터가 없는 경우]</h3>
      <UserProfile user={null} />
    </div>
  );
}

// 연습문제 2: Notification 컴포넌트 (삼항 연산자 사용)
// 문제:
// 알림 개수에 따라 메시지를 다르게 보여주는 Notification 컴포넌트를 작성하세요.

// 요구사항:
// 1. props.count가 0보다 클 때: "새로운 알림이 {count}개 있습니다."를 렌더링합니다.
// 2. props.count가 0일 때: "새로운 알림이 없습니다."를 렌더링합니다.
// 3. 삼항 연산자(? :)를 사용하여 코드를 간결하게 작성하세요.

// 힌트:
// {조건 ? (참일 때의 UI) : (거짓일 때의 UI)} 구조를 활용합니다.
function Notification({ count }) {
  return (
    <div>
      {/* 삼항 연산자를 사용하여 한 번에 처리 */}
      {count > 0 ? (
        <p>새로운 알림이 {count}개 있습니다.</p>
      ) : (
        <p>새로운 알림이 없습니다.</p>
      )}
    </div>
  );
}

// 사용 예시
export function NotificationExample() {
  return (
    <>
      <h3>[데이터가 있는 경우]</h3>
      <Notification count={5} />

      <h3>[데이터가 없는 경우]</h3>
      <Notification count={0} />
    </>
  );
}

// 연습문제 3: Advertisement 컴포넌트 (&& 연산자 활용)
// 문제:
// 프리미엄 여부에 따라 서로 다른 안내 문구를 표시하는
//  Advertisement 컴포넌트를 작성하세요.

// 요구사항:
// 1. props.isPremium이 true일 때: "프리미엄 회원님, 환영합니다!" 문구를 렌더링합니다.
// 2. props.isPremium이 false일 때: "광고 영역" 문구를 렌더링합니다.
// 3. 반드시 논리 연산자(&&)만을 사용하여 두 상태를 모두 처리하세요.

// 힌트:
// {조건 && (참일 때 실행)} 형태를 두 번 사용하여,
// 하나는 isPremium일 때, 다른 하나는 !isPremium일 때 작동하도록 구성합니다.
function Advertisement({ isPremium }) {
  return (
    <div>
      {/* 1. 프리미엄 회원일 때 (isPremium이 true일 때만 렌더링) */}
      {isPremium && (
        <div style={{ backgroundColor: "#e3f2fd", padding: 16, marginTop: 8 }}>
          <p>프리미엄 회원님, 광고 없는 서비스를 즐기고 계십니다!</p>
        </div>
      )}

      {/* 2. 프리미엄 회원이 아닐 때 (isPremium이 false일 때만 렌더링) */}
      {!isPremium && (
        <div style={{ backgroundColor: "#f0f0f0", padding: 16, marginTop: 8 }}>
          <p>이곳은 광고 영역입니다. 프리미엄 구독 시 광고가 제거됩니다.</p>
        </div>
      )}
    </div>
  );
}

// 사용 예시
export function AdvertisementExample() {
  return (
    <>
      <h3>[데이터가 있는 경우]</h3>
      <Advertisement isPremium={true} />
      <h3>[데이터가 없는 경우]</h3>
      <Advertisement isPremium={false} />
    </>
  );
}
