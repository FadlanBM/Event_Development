<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('event', function (Blueprint $table) {
            $table->id('eventid')->nullable();
            // $table->foreign('user_id')->nullable()->references('user_id')->on('user');
            $table->string('uraian')->nullable();
            $table->string('tujuan')->nullable();
            $table->date('tanggal')->nullable();
            $table->time('waktu')->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('event');
    }
};
