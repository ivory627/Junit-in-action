package com.study.junit.ch02;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SUT {
    private String systemName;
    private boolean isVerified;
    private List<Job> jobs = new ArrayList<>();
    private Job currentJob;

    public SUT(String systemName) {
        this.systemName = systemName;
        System.out.println(systemName + " from class " + getClass().getSimpleName() + " is initializing.");
        this.isVerified = false;
    }

    public boolean canReceiveRegularWork() {
        System.out.println(systemName + " from class " + getClass().getSimpleName() + " can receive regular work.");
        return true;
    }

    public boolean canReceiveAdditionalWork() {
        System.out.println(systemName + " from class " + getClass().getSimpleName() + " cannot receive additional work.");
        return false;
    }

    public void close() {
        System.out.println(systemName + " from class " + getClass().getSimpleName() + " is closing.");
    }

    String hello() {
        return "Hello";
    }

    String bye() {
        return "Bye";
    }

    String talk() {
        return "How are you?";
    }

    public String getSystemName() {
        return systemName;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void verify() {
        this.isVerified = true;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public Object[] getJobsAsArray() {
        return jobs.toArray();
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void run() {
        if (jobs.size() > 0) {
            currentJob = jobs.remove(0);
            System.out.println("Running job: " + currentJob);
            return;
        }
        throw new NoJobException("실행할 작업이 없습니다!");
    }

    public void run(int jobDuration) throws InterruptedException {
        if (jobs.size() > 0) {
            currentJob = jobs.remove(0);
            System.out.println("Running job: " + currentJob + " lasts " + jobDuration + " milliseconds");
            Thread.sleep(jobDuration);
            return;
        }
        throw new NoJobException("실행할 작업이 없습니다!");
    }


    public void run(Job currentJob) {
        this.currentJob = currentJob;
    }

    public boolean hasJobToRun() {
        return currentJob != null;
    }


}