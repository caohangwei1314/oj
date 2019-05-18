package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Solution;
import com.noi.oj.domain.SourceCode;
import com.noi.oj.domain.SubmitMap;
import com.noi.oj.service.SolutionService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/solution")
public class SolutionController extends BaseController {

    @Autowired
    private SolutionService solutionService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(@RequestBody Solution record, HttpServletRequest request) {
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        record.setUserId(userId);
        return BaseController.result(solutionService.insert(record), null, null);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Solution record) {
        return BaseController.result(solutionService.update(record), null, null);

    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public BaseController select(@RequestBody Conditions record, HttpServletRequest request) {
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        PageBean pageBean = solutionService.selectList(record);
        if (pageBean != null)
            return BaseController.result(1, null, pageBean);
        else
            return BaseController.result(0, null, null);

    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public BaseController submit(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        List<SubmitMap> submitMaps = solutionService.submit(userId);
        if (submitMaps.size() > 0 && submitMaps != null)
            return BaseController.result(1, null, submitMaps);
        else
            return BaseController.result(0, "暂无提交", null);

    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public BaseController load(@RequestParam("id") Integer id, HttpServletRequest request) {
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Conditions record = new Conditions();
        record.setUserId(userId);
        record.setProblemId(id);
        SourceCode sourceCode = solutionService.selectLoad(record);
        if (sourceCode != null)
            return BaseController.result(1, null, sourceCode);
        else
            return BaseController.result(0, "暂无记录", null);

    }
}
