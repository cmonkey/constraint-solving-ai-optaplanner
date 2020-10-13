# constraint-solving-ai-optaplanner

## Application run failed 

由于在OptaPlannerAutoConfiguration 构建solverFactory 对象时，会构建SolverConfigContext

而SolverConfigContext 对象需要KieContainer 对象

而KieContainer 对象需要ReleaseId 等对象的定义

而此项目中的依赖，不能找到ReleaseId 对象的定义

目前系统不能正常启动

尝试将spring boot 的版本退回到example 定义的版本2.2.6 

但并不能起效， 目前看来和spring boot version 无关

主要还是org.kie 的依赖版本存在问题

--  cmonkey 2020年10月13日16:10:47

原来是因为对org.kie 依赖包下载出现了问题导致的上述问题，将.m2 下的org.kie 删除，重新下载可以将此问题修复

-- cmonkey 2020年10月13日17:06:41
