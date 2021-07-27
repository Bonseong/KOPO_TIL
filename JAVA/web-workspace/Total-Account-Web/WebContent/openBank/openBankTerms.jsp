<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<title>세진저축은행</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="/Total-Account-Web/resources/assets/css/form.css"></link>
<script>
$(document).ready(function() {
	
	
	
})

if($("#req").is(":checked") == true) {
		$('#btn-next').click(function() {
			location.href = "openBankEnroll.do"
		})
		}
	
	
	$('#btn-main').click(function() {
		location.href = "redirect:/"
	})
</script>

<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>

	<div class="container">
		<div align="center" style="margin-top: 150px;">
			<hr width="80%">
			<h2>오픈뱅킹</h2>
			<hr width="80%">
		</div>

		<textarea rows="50" cols="160">제1장 총칙
제1조 (목적)
본 약관은 주식회사 세진네트워크(이하 ‘회사’라 합니다)가 제공하는 세진저축은행 서비스 중 오픈뱅킹 서비스를 이용자가 이용함에 있어, 회사와 이용자 간 권리·의무 및 이용자의 이용절차 등에 관한 사항을 규정하는 것을 그 목적으로 합니다.


제2조 (정의)

① 본 약관에서 사용하는 용어의 정의는 아래와 같습니다.

1. ‘기본약관’ 이라 함은 회사가 세진저축은행 서비스의 이용과 관련하여, 회사와 이용자의 권리, 의무 및 책임사항, 서비스의 이용과 절차, 기타 필요한 사항을 규정하기 위하여 만들고 유지하고 있는 ‘세진저축은행 이용약관’을 의미합니다.
2. ‘기본이용계약’이라 함은 회사가 제공하는 세진저축은행 서비스의 이용과 관련하여 회사와 이용자 간 기본약관에 근거하여 성립한 계약을 의미합니다.
3. ‘오픈뱅킹 시스템’이라 함은 사단법인 금융결제원(이하 ‘금융결제원’)이 구축하고 금융기관들이 참여하여, 표준화된 형태로 금융서비스를 제공하는 시스템을 의미합니다.
4. ‘오픈뱅킹 서비스’라 함은 세진저축은행 서비스의 일부로서, 본 약관에 따라 회사가 오픈뱅킹 시스템을 이용하여 이용자에게 제공하는 서비스를 의미합니다. 오픈뱅킹 서비스의 세부적인 내용은 본 약관 제5조에서 정합니다.
5. ‘이용자’라 함은 회사와 기본이용계약을 체결한 자 중 제3조에 따라 오픈뱅킹 서비스를 제공받기로 한 자를 의미합니다.
6. ‘웹사이트’ 및 ‘모바일 어플리케이션’이라 함은 별도의 설명이 없는 이상 회사가 세진저축은행 서비스를 제공하는 웹사이트 및 모바일 어플리케이션을 의미합니다.
7. ‘전자문서’라 함은 전자문서 및 전자거래 기본법 제2조 제1호에 따른 작성, 송신·수신 또는 저장된 정보를 의미합니다.
8. ‘금융기관’라 함은 오픈뱅킹 시스템에 참여하는 은행 등 금융기관을 의미합니다.
② 본 조 및 본 약관의 다른 조항에서 정의한 것을 제외하고는 본 약관에서 사용하는 용어의 의미는 관련 법령에 정한 바에 따릅니다.

제3조 (오픈뱅킹 서비스 이용에 관한 부속계약)

① 회사는 오픈뱅킹 서비스 이용에 관한 부속계약(이하 ‘오픈뱅킹이용계약’이라 합니다)을 체결한 이용자에 한해 오픈뱅킹 서비스를 제공합니다. 오픈뱅킹이용계약은 이용자가 세진저축은행 서비스에서 회사가 정한 양식에 따라 오픈뱅킹 서비스 이용 신청을 하고 본 약관의 내용에 동의를 한 후 회사가 이를 승낙함으로써 성립됩니다.
② 회사는 다음 각 호에 해당하는 이용 신청에 대해서는 승낙을 하지 않거나, 승낙 이후라도 이용의 제한 또는 오픈뱅킹이용계약을 해지할 수 있습니다.

1. 이용신청자가 신청시 제공한 정보에 허위, 누락이나 오류가 있거나, 회사가 요구하는 기준을 충족하지 못하는 경우
2. 이용신청자가 오픈뱅킹 서비스 또는 그 외 세진저축은행 서비스와 관련하여 자격상실, 이용정지 등의 기록이 있는 경우
3. 회사가 정한 서비스 제공환경이 아니거나 기술상 서비스 제공이 불가능한 경우
4. 신청 명의가 신청자 본인의 명의가 아닌 경우
5. 이미 이용 중인 이용자가 중복하여 이용신청을 하는 경우
6. 만 14세 이하의 자가 이용신청 하는 경우
7. 법인 명의로 이용신청 하는 경우
8. 관계 법령에 따라 이용신청을 거절할 의무 또는 권한이 인정되는 경우
③ 회사는 제7조에 따른 인증을 비롯하여 이용자에게 오픈뱅킹 서비스에 필요한 사항을 요구할 수 있습니다. 이용자가 이를 이행하지 않을 경우 이용자는 회사가 제공하는 서비스의 전부 또는 일부를 이용할 수 없거나 이용에 제한을 받을 수 있습니다.
④ 오픈뱅킹이용계약은 이용자와 회사 간 기본이용계약의 한 부분을 구성하며, 기본이용계약 관계가 유효하게 존속하고 있음을 전제합니다. 사유를 불문하고 기본이용계약이 해제·해지 기타 효력을 상실하게 되는 경우 오픈뱅킹이용계약은 그에 따라 함께 효력을 상실합니다.
⑤ 별도로 명시하지 않은 이상 본 약관에서 정하고 있는 해지는 오픈뱅킹이용계약만의 해지를 의미합니다. 이용자와 회사 간 세진저축은행 서비스에 관한 기본이용계약 관계는 기본약관에서 정한 바에 따릅니다.
⑥ 이용자는 언제든지 오픈뱅킹이용계약을 해지할 수 있습니다. 오픈뱅킹 서비스 이용에 관한 해지는 웹사이트 또는 모바일 어플리케이션에서 회사가 제공하는 방법(오픈뱅킹 서비스 이용 탈퇴 메뉴)에 따릅니다. 회사는 본 약관에서 정하고 있는 바에 따라 오픈뱅킹이용계약을 해지할 수 있습니다.

제4조 (약관의 명시, 설명 및 변경)

① 회사는 이용자가 약관의 내용을 알 수 있도록 웹사이트 및 모바일 어플리케이션에 본 약관을 게시합니다.
② 회사는 이용자의 요청이 있는 경우 전자문서의 전송(전자우편을 이용한 전송을 포함합니다) 또는 모사전송의 방식에 의하여 본 약관의 사본을 이용자에게 교부합니다.
③ 회사는 이용자가 약관의 내용에 대한 설명을 요청하는 경우 다음 각 호의 어느 하나의 방법으로 이용자에게 약관의 중요내용을 설명합니다(설명의 방법은 회사가 선택할 수 있습니다).

1. 약관의 중요내용을 이용자에게 직접 설명
2. 약관의 중요내용에 대한 설명을 전자적 장치를 통하여 이용자가 알기 쉽게 표시하고 이용자로부터 해당 내용을 충분히 인지하였다는 의사표시를 전자적 장치를 통하여 수령
④ 회사가 본 약관을 변경하는 때에는 그 시행일 1월 전에 변경되는 약관을 웹사이트 또는 모바일어플리케이션에 게시함으로써 이용자에게 공지합니다. 다만, 법령의 개정으로 인하여 긴급하게 약관을 변경한 때에는 변경된 약관을 웹사이트 또는 모바일어플리케이션에 1개월 이상 게시하고 이용자에게 전자우편 등을 통하여 사후 통지합니다.
⑤ 회사는 제4항의 공지나 통지를 할 경우 “이용자가 변경에 동의하지 아니한 경우 공지나 통지를 받은 날로부터 변경된 약관이 시행되기 전날의 영업일까지 계약을 해지할 수 있으며, 계약해지의 의사표시를 하지 아니한 경우에는 변경에 동의한 것으로 본다.”라는 취지의 내용을 공지하거나 통지합니다.
⑥ 이용자는 약관의 변경내용이 게시되거나 통지된 후부터 변경되는 약관의 시행일 전의 영업일까지 회사와 오픈뱅킹이용계약을 해지할 수 있습니다.

제5조 (오픈뱅킹 서비스의 종류)

① 본 약관에 따라 제공되는 오픈뱅킹 서비스는 잔액조회업무 및 거래내역조회업무(각 업무와 부속되거나 연계된 서비스 포함)를 의미합니다.
② 제1항에 따른 서비스는 회사가 미리 서비스 대상으로 고지한 금융기관에 한하며, 회사는 대상 금융기관 별로 제공하는 서비스의 내용을 달리 정할 수 있습니다. 대상 금융기관 및 금융기관 별 제공 서비스의 내용은 웹사이트 및 모바일 어플리케이션을 통해 별도로 안내합니다.
③ 회사는 필요 시 이용자에게 제공하는 오픈뱅킹 서비스를 추가하거나 변경할 수 있으며, 이 경우 사전에 이용자에게 고지하도록 합니다.

제6조 (서비스 이용시간)

① 회사는 이용자에게 00시 05분부터 23시 55분까지 오픈뱅킹 서비스를 제공함을 원칙으로 합니다. 다만, 서비스 제공 시간은 금융기관, 금융결제원 기타 오픈뱅킹 시스템의 사정에 따라 달리 정할 수 있습니다.
② 정보통신설비의 보수, 점검 기타 기술상의 필요나 금융기관, 금융결제원 기타 오픈뱅킹 시스템의 사정에 의하여 오픈뱅킹 서비스의 중단이 불가피한 경우, 회사는 서비스 중단 3일 전까지 모바일 어플리케이션에 오픈뱅킹 서비스 중단 사실을 게시한 후 오픈뱅킹 서비스를 일시 중단할 수 있습니다. 다만, 시스템 장애복구, 긴급한 프로그램 보수, 외부요인 등 불가피한 경우에는 사전 게시 없이 오픈뱅킹 서비스를 중단할 수 있습니다.

제7조 (인증)

회사는 오픈뱅킹 서비스의 종류 및 보안수준에 따라 별도로 인증수단을 적용할 수 있습니다.

제8조 (이용계좌의 등록)

① 이용자가 오픈뱅킹 서비스를 이용하기 위해서는 이용계좌를 등록해야 합니다.
② 이용계좌의 등록은 회사가 정한 방법에 따라 모바일어플리케이션 등을 통하여 이루어집니다.
③ 이용자가 잔액 및 거래내역을 조회하기 위해서는, 금융실명거래 및 비밀보장에 관한 법률 등 법령에 따라 정보제공 등에 관한 동의가 필요합니다. 본 항에 따른 동의는 모바일어플리케이션 등을 통하여 회사가 제공하는 방법에 따라 이루어집니다.
④ 이용자는 본 조에 따른 이용계좌의 등록 및 정보제공에 관한 동의를 철회할 수 있습니다. 회사는 모바일어플리케이션 등을 통하여 철회 방법을 제공합니다.

제9조 (잔액 및 거래내역의 조회)

① 이용자는 오픈뱅킹 서비스를 통하여 이용계좌의 잔액 또는 거래내역의 조회를 지시할 수 있습니다.
② 회사는 제1항의 지시를 받은 후, 오픈뱅킹 시스템을 이용하여 이용계좌의 잔액 또는 거래내역을 받아 이용자에게 제공합니다.

제10조 (개인정보의 보호)

① 회사는 오픈뱅킹 서비스를 제공함에 있어서 취득한 이용자의 인적사항, 이용자의 계좌, 접근매체 및 전자금융거래의 내용과 실적에 관한 정보 또는 자료를 관련 법령에 의하거나 이용자의 동의를 얻지 아니하고 제3자에게 제공, 누설하거나 업무 상 목적 외에 사용하지 아니합니다.
② 회사는 이용자가 안전하게 오픈뱅킹 서비스를 이용할 수 있도록 이용자의 개인정보보호를 위하여 개인정보처리방침을 운용합니다. 회사의 개인정보취급방침은 웹사이트 또는 모바일 어플리케이션에 링크된 화면에서 확인할 수 있습니다.

제11조 (서비스의 제한)

회사는 다음 각 호의 어느 하나의 경우에는 오픈뱅킹 서비스의 전부 또는 일부를 제한할 수 있습니다.

1. 법령에 따라 이용자에게 오픈뱅킹 서비스를 제공하는 것이 허용되지 않거나 위법하다고 판단할 만한 합리적인 사유가 있는 경우
2. 이용자가 오픈뱅킹 서비스를 비정상적인 방법으로 이용하고 있다고 판단할 만한 합리적인 사유가 있는 경우
3. 제3조 제2항 각 호의 사유가 있는 경우(이 경우 오픈뱅킹이용계약의 해지 여부와 무관하게 오픈뱅킹 서비스 제공을 제한할 수 있음)
4. 정보제공에 대한 동의가 없는 경우(철회한 경우를 포함) 등 오픈뱅킹 서비스를 제공하기 위하여 필요한 법령상 요건이나 회사가 정한 요건, 절차가 충족되지 않은 경우
5. 기타 회사가 이용자에게 오픈뱅킹 서비스의 제공을 거부할 필요가 있다고 인정할 만한 합리적인 사유가 있는 경우

제12조 (회사의 책임)

① 회사는 회사의 고의 또는 과실로 인해 법에 따른 손해배상책임이 인정되는 한도에서 이용자에게 책임을 부담합니다.
② 오픈뱅킹 시스템 및 오픈뱅킹 시스템에 참여하고 있는 금융기관과 관련하여 발생한 문제에 대해서는 회사가 책임을 부담하지 않습니다.

제13조 (분쟁처리절차)

① 이용자는 오픈뱅킹 서비스와 관련하여 이의가 있는 경우 서면(전자문서를 포함한다) 또는 전자적 장치를 이용하여 회사에 분쟁처리를 신청할 수 있습니다.
② 회사는 오픈뱅킹 서비스와 관련한 분쟁처리를 위한 분쟁처리책임자 및 담당자를 지정하고, 그 연락처를 웹사이트 또는 모바일 어플리케이션을 통해 이용자에게 알립니다.
③ 회사는 제1항의 신청을 받은 날로부터 15일 이내에 분쟁처리에 대한 조사 또는 처리 결과를 이용자에게 알려야 합니다.
④ 이용자는 서비스와 관련하여 이의가 있는 경우 본 조에 의한 절차 외에 소비자기본법에 따른 한국소비자원의 소비자분쟁조정위원회에 대한 분쟁조정 신청 등 법령에 따른 분쟁해결을 신청할 수 있습니다.

제14조 (재판관할)

회사와 이용자 간 발생한 분쟁에 관해서는 민사소송법에 따라 관할을 가지는 법원의 판결에 따릅니다.

제15조 (회사의 안정성 확보 의무)

회사는 오픈뱅킹 서비스가 안전하게 처리될 수 있도록 전자적 전송이나 처리를 위한 인력, 시설, 전자적 장치 등에 관하여 금융결제원, 기타 법령에 따른 감독기관이 정하는 기준을 준수합니다.

제16조 (회사에 대한 요청, 통지 등)

이용자가 본 약관에 따라 회사에 대한 요청, 통지 등을 하고자 할 경우, 다음의 주소, 전자우편주소, 전화번호로 하는 것을 원칙으로 합니다. 다만 개별 조항에서 통지방법을 제한하거나 별도의 연락처를 정하고 있는 경우에는 그에 따라야 합니다.

주소 : 서울 독산역 조세진의 집
전자 우편주소: 9bonseong@naver.com
전화번호 : 010-4773-9853

제17조 (다른 약정 등과의 관계)

① 회사와 이용자 사이에 개별적으로 합의한 사항이 본 약관에 정한 사항과 다를 때에는 그 합의사항을 본 약관에 우선하여 적용합니다.
② 본 약관에서 정하고 있지 않은 사항에 관하여는 오픈뱅킹 서비스와 관련해서도 여전히 기본약관이 적용됩니다.
③ 본 약관과 기본약관, 그 외 이용자와 회사 간 적용되는 다른 약관 등에 서로 다른 내용이 존재할 경우 오픈뱅킹 서비스와 관련해서는 본 약관이 우선하는 것을 원칙으로 하되, 이러한 약관들은 최대한 모순되지 않고 조화롭게 해석하도록 합니다.
   </textarea>
		<br> <input type="checkbox" name="req"> 개인정보 수집 및 이용에
		동의합니다.<br>

		<div style="text-align: center;">

			<button id="btn-next" type="submit" class="btn btn-info"
				onclick="location.href='/Total-Account-Web/openBankEnroll.do';">
				<i class="icon-hand-right"></i>다음
			</button>
			<button id="btn-main" class="btn btn-info"
				onclick="location.href=/Total-Account-Web/">
				<i class="icon-hand-right"></i> 메인
			</button>
		</div>



	</div>
	<header>
		<jsp:include page="/jsp/include/bottom.jsp" />
	</header>
</body>