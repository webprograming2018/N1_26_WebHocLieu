<jsp:include page="header.jsp"></jsp:include>
    <div id="wrap" class="wrap">
        <main>
            <article id="view-work">
                <div class="content">
                    <section>
                        <div class="wrap">
                            <div id="content-table">
                                <div class="wrap">
                                    <div class="table-container">
                                        <div class="table-menu">
                                            <div class="icon-menu"><i class="fas fa-bars"></i></div>
                                            <div class="menu-content">
                                                <ul>
                                                    <li><input type="checkbox" name="group" value="group" checked><span>Nhóm</span></li>
                                                    <li><input type="checkbox" name="studentName" value="studentName"
                                                               checked><span>H? Tên</span></li>
                                                    <li><input type="checkbox" name="studentCode" value="studentCode"
                                                               checked><span>Mã
                                                            Sinh Viên</span></li>
                                                    <li><input type="checkbox" name="project" value="project" checked><span>??
                                                            tài</span></li>
                                                    <li><input type="checkbox" name="one" value="one"><span>Báo Cáo 1</span></li>
                                                    <li><input type="checkbox" name="two" value="two"><span>Báo Cáo 2</span></li>
                                                    <li><input type="checkbox" name="three" value="three" checked><span>Báo
                                                            Cáo 3</span></li>
                                                    <li><input type="checkbox" name="document" value="document"><span>Link
                                                            B?n m?m</span></li>
                                                    <li><input type="checkbox" name="sourceCode" value="sourceCode" checked><span>Link
                                                            Mã ngu?n</span></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <table class="table-body">
                                            <thead>
                                                <tr>
                                                    <th id="group" class="group" rowspan="2">
                                                        <p>NH<i class="fas fa-sort"></i></p>
                                                    </th>
                                                    <th class="member" colspan="2">
                                                        <p>Thành viên</p>
                                                    </th>
                                                    <th id="project" class="project" rowspan="2">
                                                        <p>?? tài</p>
                                                    </th>
                                                    <th id='one' class='one' colspan="3">Báo cáo 1</th>
                                                    <th id='two' class='two' colspan="3">Báo cáo 2</th>
                                                    <th id='three' class='three' colspan="3">Báo cáo 3</th>
                                                    <th class="document" id="document" rowspan="2">
                                                        <p>B?n m?m</p>
                                                    </th>
                                                    <th class="sourceCode" id="sourceCode" rowspan="2">
                                                        <p>Mã ngu?n</p>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th id="studentName" class="studentName">
                                                        <p>H? tên</p>
                                                    </th>
                                                    <th id="studentCode" class="studentCode">
                                                        <p>Mã SV</p>
                                                    </th>
                                                    <th class='require one'>
                                                        <p>TC1</p>
                                                    </th>
                                                    <th class='require one'>
                                                        <p>TC2</p>
                                                    </th>
                                                    <th class='require one'>
                                                        <p>TC3</p>
                                                    </th>
                                                    <th class='require two'>
                                                        <p>TC1</p>
                                                    </th>
                                                    <th class='require two'>
                                                        <p>TC2</p>
                                                    </th>
                                                    <th class='require two'>
                                                        <p>TC3</p>
                                                    </th>
                                                    <th class='require three'>
                                                        <p>TC1</p>
                                                    </th>
                                                    <th class='require three'>
                                                        <p>TC2</p>
                                                    </th>
                                                    <th class='require three'>
                                                        <p>TC3</p>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th class="group"><input type="text" name="group" /></th>
                                                    <th class="studentName"><input type="text" name="studentName" /></th>
                                                    <th class="studentCode"><input type="text" name="studentCode" /></th>
                                                    <th class="project"><input type="text" name="project" /></th>
                                                    <th class='require one'><input type="text" name="one1" /></th>
                                                    <th class='require one'><input type="text" name="one2" /></th>
                                                    <th class='require one'><input type="text" name="one3" /></th>
                                                    <th class='require two'><input type="text" name="two1" /></th>
                                                    <th class='require two'><input type="text" name="two2" /></th>
                                                    <th class='require two'><input type="text" name="two3" /></th>
                                                    <th class='require three'><input type="text" name="three1" /></th>
                                                    <th class='require three'><input type="text" name="three2" /></th>
                                                    <th class='require three'><input type="text" name="three3" /></th>
                                                    <th class="document"><input type="text" name=document></th>
                                                    <th class="sourceCode"><input type="text" name="sourceCode" /></th>
                                                </tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </article>				
        </main>
    </div>

    <!--<script src="./studyWeb/showCode/ace.js" type="text/javascript" charset="utf-8"></script>-->
    <script type="text/javascript" src="./viewWork/viewWork.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
