package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.dataRepos.SkillRepository;
import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String displayEmployers (Model model){
        model.addAttribute("id", "name");
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }
    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            model.addAttribute(new Skill());
            return "skills/add";
        }
        skillRepository.save(newSkill);

        return "redirect:";
    }
    @GetMapping("view/{skillId}")
    public String displayViewSkills(Model model, @PathVariable int skillId) {

        Optional optSkills = skillRepository.findById(skillId);
        if (optSkills.isPresent()) {
            Skill skill = (Skill) optSkills.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}

